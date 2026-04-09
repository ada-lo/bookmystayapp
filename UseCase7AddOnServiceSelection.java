public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        Reservation res = new Reservation("Alice", "Single");
        System.out.println("Booking Confirmed: " + res);

        AddOnServiceManager addOnManager = new AddOnServiceManager();
        AddOnService breakfast = new AddOnService("Breakfast", 15.0);
        AddOnService spa = new AddOnService("Spa Treatment", 50.0);

        System.out.println("\nAdding services...");
        addOnManager.addService(res.getReservationId(), breakfast);
        addOnManager.addService(res.getReservationId(), spa);

        System.out.println("Services for " + res.getGuestName() + ": " + addOnManager.getServices(res.getReservationId()));
        System.out.println("Total Add-On Cost: $" + addOnManager.calculateTotalAddOnCost(res.getReservationId()));
    }
}