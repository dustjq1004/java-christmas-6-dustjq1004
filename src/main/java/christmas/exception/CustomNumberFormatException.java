package christmas.exception;

public class CustomNumberFormatException extends NumberFormatException {

    public CustomNumberFormatException(String errorMessage) {
        super(errorMessage);
    }
}
