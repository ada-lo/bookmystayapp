import java.util.List;

public class BookingReportService {
    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    public void generateSummaryReport() {
        List<Reservation> records = history.getHistory();
        System.out.println("=== Booking Summary Report ===");
        System.out.println("Total Bookings: " + records.size());
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i).getGuestName() + " - " + records.get(i).getRoomType() + " Room (ID: " + records.get(i).getReservationId() + ")");
        }
        System.out.println("==============================");
    }
}