import java.io.*;

public class PersistenceService {
    private static final String FILE_NAME = "inventory_snapshot.dat";

    public void saveState(RoomInventory inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            System.out.println("System state persisted successfully.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    public RoomInventory loadState() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No previous state found. Starting fresh.");
            return new RoomInventory();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            RoomInventory loaded = (RoomInventory) ois.readObject();
            System.out.println("System state restored successfully.");
            return loaded;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading state. Starting fresh. Caused by: " + e.getMessage());
            return new RoomInventory();
        }
    }
}