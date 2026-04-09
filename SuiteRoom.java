public class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 50.0, 300.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Suite Room: 3 beds, 50 sqm, $300.0/night");
    }
}