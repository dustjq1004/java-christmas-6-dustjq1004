package christmas.utils;

import christmas.model.Menu;
import java.util.HashMap;
import java.util.Map;

public class StringConverter {

    public static int convertToInteger(String target) {
        return Integer.parseInt(target);
    }

    public static Map<Menu, Integer> convertOrderToMap(String target) {
        Map<Menu, Integer> orders = new HashMap<>();
        for (String order : target.split(",")) {
            String[] details = order.split("-");
            Menu menuName = Menu.getMenuByName(details[0]);
            int menuCount = Integer.parseInt(details[1]);
            orders.put(menuName, menuCount);
        }
        return orders;
    }
}
