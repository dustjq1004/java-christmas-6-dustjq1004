package christmas.model;

import christmas.exception.CustomIllegalArgumentException;
import christmas.exception.ErrorMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Order {

    private final static int LIMIT_COUNT = 20;

    private final List<OrderedFood> order;

    public Order(List<OrderedFood> order) {
        validate(order);
        this.order = order;
    }

    private void validate(List<OrderedFood> order) {
        validateDuplicate(order);
        validateCount(order);
        validateDrink(order);
    }

    private void validateDrink(List<OrderedFood> order) {
        Optional<OrderedFood> first = order.stream()
                .filter((orderedFood) -> !orderedFood.compareTo(FoodType.DRINK))
                .findFirst();
        if (first.isEmpty()) {
            throw new CustomIllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateCount(List<OrderedFood> order) {
        if (sumOrderCount(order) > LIMIT_COUNT) {
            throw new CustomIllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<OrderedFood> order) {
        if (order.size() != order.stream().distinct().count()) {
            throw new CustomIllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

    public int getTotalOrderCount() {
        return sumOrderCount(order);
    }

    private int sumOrderCount(List<OrderedFood> order) {
        return order.stream().mapToInt(orderedFood -> orderedFood.getCount()).sum();
    }

    public int countFoodType(FoodType foodType) {
        return order.stream()
                .filter((food) -> food.compareTo(foodType))
                .mapToInt((food) -> food.getCount())
                .sum();
    }

    public int sumTotalPrice() {
        return order.stream().mapToInt((food) ->
                food.calculatePrice()
        ).sum();
    }

    public Map<Menu, Integer> orderToMap() {
        Map<Menu, Integer> collect = order.stream()
                .collect(Collectors.toMap(OrderedFood::getMenu, OrderedFood::getCount));
        return Collections.unmodifiableMap(new HashMap<>(collect));
    }
}
