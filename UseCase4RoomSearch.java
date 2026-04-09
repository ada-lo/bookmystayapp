import java.util.Arrays;

public class UseCase4RoomSearch {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRoom("Single", 10);
        inventory.initializeRoom("Double", 0); // Sold out
        inventory.initializeRoom("Suite", 2);

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        SearchService searchService = new SearchService(inventory, Arrays.asList(singleRoom, doubleRoom, suiteRoom));
        
        System.out.println("Searching for available rooms...");
        searchService.displayAvailableRooms();
    }
}