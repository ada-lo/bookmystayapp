import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> inventory;

    public RoomInventory() {
        this.inventory = new HashMap<>();
    }

    public void initializeRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailableCount(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    public void displayInventory() {
        System.out.println("--- Current Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Room: " + entry.getValue() + " available");
        }
    }
}