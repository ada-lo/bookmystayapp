public class UseCase3InventorySetup {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        
        inventory.initializeRoom("Single", 10);
        inventory.initializeRoom("Double", 5);
        inventory.initializeRoom("Suite", 2);
        
        System.out.println("Initial state:");
        inventory.displayInventory();
        
        System.out.println("\nUpdating state after a booking...");
        inventory.updateAvailability("Single", 9);
        inventory.updateAvailability("Suite", 1);
        
        inventory.displayInventory();
    }
}