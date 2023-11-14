package christmas.utils;

import christmas.model.Menu;
import christmas.model.Order;
import christmas.model.OrderedFood;
import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {

    public static Order generateOrder(String target) {
        List<OrderedFood> order = new ArrayList<>();
        for (String orderedFood : target.split(",")) {
            String[] details = orderedFood.split("-");
            Menu menu = Menu.getMenuByName(details[0]);
            int menuCount = Integer.parseInt(details[1]);
            order.add(new OrderedFood(menu, menuCount));
        }
        return new Order(order);
    }
}
