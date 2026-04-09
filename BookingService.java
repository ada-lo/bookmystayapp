import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BookingService {
    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        this.allocatedRooms = new HashMap<>();
    }

    public void processQueue(BookingRequestQueue queue) {
        while (queue.hasRequests()) {
            Reservation req = queue.getNextRequest();
            allocateRoom(req);
        }
    }

    public void allocateRoom(Reservation reservation) {
        String type = reservation.getRoomType();
        int available = inventory.getAvailableCount(type);
        
        if (available > 0) {
            String generatedId = UUID.randomUUID().toString();
            allocatedRooms.putIfAbsent(type, new HashSet<>());
            
            // Uniqueness validation by Set property
            if(allocatedRooms.get(type).add(generatedId)) {
                inventory.updateAvailability(type, available - 1);
                System.out.println("Confirmed " + reservation.getGuestName() + " for " + type + " Room (ID: " + generatedId + ")");
            } else {
                System.out.println("Error: Room ID collision.");
            }
        } else {
            System.out.println("Failed: " + reservation.getGuestName() + "'s request for " + type + " Room (No availability).");
        }
    }
}