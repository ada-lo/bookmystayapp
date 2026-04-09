public class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 20.0, 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Single Room: 1 bed, 20 sqm, $100.0/night");
    }
}