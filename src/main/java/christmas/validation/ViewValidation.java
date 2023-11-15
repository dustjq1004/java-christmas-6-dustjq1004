package christmas.validation;

import christmas.exception.CustomIllegalArgumentException;
import christmas.exception.CustomNumberFormatException;
import christmas.exception.ErrorMessage;

public class ViewValidation {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static void validateReservationDate(String date) {
        final int parsedDate = validateNumberFormat(date);

        if (parsedDate < MIN_DATE && MAX_DATE < parsedDate) {
            throw new CustomIllegalArgumentException(ErrorMessage.DATE_ERROR_MESSAGE.getMessage());
        }
    }

    private static int validateNumberFormat(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException(ErrorMessage.DATE_ERROR_MESSAGE.getMessage());
        }
    }
}
