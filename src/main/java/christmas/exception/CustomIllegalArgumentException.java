package christmas.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public CustomIllegalArgumentException(String errorMessage) {
        super(errorMessage);
    }
}
