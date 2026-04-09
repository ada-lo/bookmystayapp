import java.util.Stack;

public class CancellationService {
    private RoomInventory inventory;
    private BookingHistory history;
    private Stack<String> releasedRoomIds;

    public CancellationService(RoomInventory inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
        this.releasedRoomIds = new Stack<>();
    }

    public void cancelBooking(Reservation reservation) {
        if (history.getHistory().contains(reservation)) {
            // Revert state
            releasedRoomIds.push(reservation.getReservationId());
            int currentAvailability = inventory.getAvailableCount(reservation.getRoomType());
            inventory.updateAvailability(reservation.getRoomType(), currentAvailability + 1);
            
            System.out.println("Successfully cancelled booking for " + reservation.getGuestName() + ". Room ID " + reservation.getReservationId() + " released.");
        } else {
            System.out.println("Cancellation failed: Reservation not found.");
        }
    }

    public void displayRecentCancellations() {
        System.out.println("Recent cancelled room IDs: " + releasedRoomIds);
    }
}