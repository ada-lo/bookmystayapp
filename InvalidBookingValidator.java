public class InvalidBookingValidator {
    public static void validateBooking(String roomType, int availableCount) throws InvalidBookingException {
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException("Room type cannot be null or empty.");
        }
        if (availableCount <= 0) {
            throw new InvalidBookingException("No availability for room type: " + roomType);
        }
    }
}