public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleAvailability = 10;
        int doubleAvailability = 5;
        int suiteAvailability = 2;

        singleRoom.displayDetails();
        System.out.println("Available: " + singleAvailability);

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailability);

        suiteRoom.displayDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}