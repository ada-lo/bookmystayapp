public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue queue;
    private RoomInventory inventory;

    public ConcurrentBookingProcessor(BookingRequestQueue queue, RoomInventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            Reservation request;
            synchronized (queue) {
                if (!queue.hasRequests()) {
                    break;
                }
                request = queue.getNextRequest();
            }

            if (request != null) {
                synchronized (inventory) {
                    int available = inventory.getAvailableCount(request.getRoomType());
                    if (available > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        inventory.updateAvailability(request.getRoomType(), available - 1);
                        System.out.println(Thread.currentThread().getName() + " confirmed: " + request.getGuestName() + " for " + request.getRoomType());
                    } else {
                        System.out.println(Thread.currentThread().getName() + " failed: " + request.getGuestName() + " (No " + request.getRoomType() + " rooms)");
                    }
                }
            }
        }
    }
}