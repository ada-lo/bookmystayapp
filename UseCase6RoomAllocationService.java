public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRoom("Single", 1);
        inventory.initializeRoom("Double", 5);
        inventory.initializeRoom("Suite", 2);

        BookingRequestQueue queue = new BookingRequestQueue();
        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Single")); // Should fail
        queue.addRequest(new Reservation("Charlie", "Suite"));

        BookingService service = new BookingService(inventory);
        
        System.out.println("--- Processing Bookings ---");
        service.processQueue(queue);
        
        System.out.println("\n--- Final Inventory ---");
        inventory.displayInventory();
    }
}