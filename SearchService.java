import java.util.List;

public class SearchService {
    private RoomInventory inventory;
    private List<Room> allRoomTypes;

    public SearchService(RoomInventory inventory, List<Room> allRoomTypes) {
        this.inventory = inventory;
        this.allRoomTypes = allRoomTypes;
    }

    public void displayAvailableRooms() {
        System.out.println("--- Available Rooms ---");
        for (Room room : allRoomTypes) {
            String roomTypeName = room.getClass().getSimpleName().replace("Room", "");
            int availableCount = inventory.getAvailableCount(roomTypeName);
            if (availableCount > 0) {
                room.displayDetails();
                System.out.println("Currently available: " + availableCount);
            }
        }
    }
}