public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRoom("Single", 9); // After 1 booking
        
        BookingHistory history = new BookingHistory();
        Reservation res1 = new Reservation("Alice", "Single");
        history.addConfirmedBooking(res1);

        CancellationService cancelService = new CancellationService(inventory, history);
        
        System.out.println("--- Initial State ---");
        inventory.displayInventory();
        System.out.println("Active Bookings: " + history.getHistory().size());

        System.out.println("\n--- Initiating Cancellation ---");
        cancelService.cancelBooking(res1);
        history.removeConfirmedBooking(res1);

        System.out.println("\n--- State After Cancellation ---");
        inventory.displayInventory();
        System.out.println("Active Bookings: " + history.getHistory().size());
        cancelService.displayRecentCancellations();
    }
}