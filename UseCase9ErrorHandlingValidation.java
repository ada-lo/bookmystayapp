public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        System.out.println("Processing valid booking...");
        try {
            InvalidBookingValidator.validateBooking("Single", 5);
            System.out.println("Validation passed. Booking confirmed.");
        } catch (InvalidBookingException e) {
            System.err.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("\nProcessing invalid booking (empty room type)...");
        try {
            InvalidBookingValidator.validateBooking("", 5);
            System.out.println("Validation passed. Booking confirmed.");
        } catch (InvalidBookingException e) {
            System.err.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("\nProcessing invalid booking (no availability)...");
        try {
            InvalidBookingValidator.validateBooking("Suite", 0);
            System.out.println("Validation passed. Booking confirmed.");
        } catch (InvalidBookingException e) {
            System.err.println("Booking Failed: " + e.getMessage());
        }
        
        System.out.println("\nSystem continues running safely after errors.");
    }
}