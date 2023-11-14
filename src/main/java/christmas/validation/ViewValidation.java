package christmas.validation;

import christmas.exception.CustomIllegalArgumentException;
import christmas.exception.CustomNumberFormatException;
import christmas.exception.ErrorMessage;

public class ViewValidation {

    private static final String MENU_PATTERN_REGEX = "\"^(\\\\w+)-(\\\\d+)$\"";
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static void validateMenuPattern(String menu) {
        if (menu.matches(MENU_PATTERN_REGEX)) {
            throw new CustomIllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

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
