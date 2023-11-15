package christmas.utils;

import christmas.exception.CustomIllegalArgumentException;
import christmas.exception.ErrorMessage;
import christmas.model.Menu;
import christmas.model.Order;
import christmas.model.OrderedFood;
import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_DASH = "-";

    public static Order generateOrder(String target) {
        try {
            List<OrderedFood> order = new ArrayList<>();
            for (String orderedFood : target.split(DELIMITER_COMMA)) {
                String[] details = orderedFood.split(DELIMITER_DASH);
                Menu menu = Menu.getMenuByName(details[0]);
                int menuCount = Integer.parseInt(details[1]);
                order.add(new OrderedFood(menu, menuCount));
            }
            return new Order(order);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new CustomIllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }
}
