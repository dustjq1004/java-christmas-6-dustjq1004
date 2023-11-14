package christmas.model;

import java.time.DayOfWeek;
import java.util.Map;

public class PreOrder {

    private final int day;
    private final Order order;

    public PreOrder(int day, Order order) {
        this.day = day;
        this.order = order;
    }

    public int getTotalCountOfFoodType(FoodType foodType) {
        return order.countFoodType(foodType);
    }

    public int getTotalOrderPrice() {
        return order.sumTotalPrice();
    }

    public int getChristmasDday() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDDayChristmas(day);
    }

    public DayOfWeek getDayofWeek() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDayOfWeek(day);
    }

    public boolean hasStar() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.hasStar(day);
    }

    public boolean isContainDayRange(final int startDay, final int endDay) {
        return startDay <= day && day <= endDay;
    }

    public Map<Menu, Integer> getOrederMap() {
        return order.orderToMap();
    }
}
