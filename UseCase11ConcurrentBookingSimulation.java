public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRoom("Single", 5);

        BookingRequestQueue queue = new BookingRequestQueue();
        for (int i = 1; i <= 10; i++) {
            queue.addRequest(new Reservation("Guest" + i, "Single"));
        }

        System.out.println("\n--- Starting Concurrent Simulation ---");
        
        Thread t1 = new Thread(new ConcurrentBookingProcessor(queue, inventory), "Agent-1");
        Thread t2 = new Thread(new ConcurrentBookingProcessor(queue, inventory), "Agent-2");
        Thread t3 = new Thread(new ConcurrentBookingProcessor(queue, inventory), "Agent-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Final Inventory ---");
        inventory.displayInventory();
    }
}