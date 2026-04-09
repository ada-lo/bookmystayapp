public class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 35.0, 150.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Double Room: 2 beds, 35 sqm, $150.0/night");
    }
}