public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        System.out.println("Simulating incoming booking requests...");
        BookingRequestQueue queue = new BookingRequestQueue();
        
        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Double"));
        queue.addRequest(new Reservation("Charlie", "Suite"));
        
        System.out.println("\nProcessing requests in FIFO order:");
        while (queue.hasRequests()) {
            Reservation request = queue.getNextRequest();
            System.out.println("Processing: " + request);
        }
    }
}