public abstract class Room {
    protected int bedCount;
    protected double size;
    protected double price;

    public Room(int bedCount, double size, double price) {
        this.bedCount = bedCount;
        this.size = size;
        this.price = price;
    }

    public abstract void displayDetails();
}