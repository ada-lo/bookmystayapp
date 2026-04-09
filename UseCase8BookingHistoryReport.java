public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService(history);

        System.out.println("Confirming bookings...");
        history.addConfirmedBooking(new Reservation("Alice", "Single"));
        history.addConfirmedBooking(new Reservation("Bob", "Double"));
        history.addConfirmedBooking(new Reservation("Charlie", "Suite"));

        System.out.println("\nGenerating report...");
        reportService.generateSummaryReport();
    }
}