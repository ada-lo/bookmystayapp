public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        PersistenceService persistenceService = new PersistenceService();
        System.out.println("--- System Startup ---");
        RoomInventory inventory = persistenceService.loadState();
        
        // If it's a fresh start (meaning inventory is empty)
        if (inventory.getAvailableCount("Single") == 0 && inventory.getAvailableCount("Double") == 0) {
            inventory.initializeRoom("Single", 10);
            inventory.initializeRoom("Double", 5);
        }

        inventory.displayInventory();
        
        System.out.println("\nModifying state (Booking a Single Room)...");
        inventory.updateAvailability("Single", inventory.getAvailableCount("Single") - 1);
        
        System.out.println("\n--- Initiating Shutdown ---");
        persistenceService.saveState(inventory);
        System.out.println("Shutdown complete.");
    }
}