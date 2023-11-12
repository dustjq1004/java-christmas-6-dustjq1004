package christmas.model;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    private final List<Menu> foods;
    private final int day;
    private final Map<String, Integer> discountType;

    public Reservation(List<Menu> foods, int day) {
        this.foods = foods;
        this.day = day;
        discountType = new HashMap<>();
    }

    public void addDiscountType(String name, int price) {
        discountType.put(name, price);
    }

    public boolean isContainDayRange(final int startDay, final int endDay) {
        return startDay <= day && day <= endDay;
    }

    public int getChristmasDday() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDDayChristmas(day);
    }

    public DayOfWeek getDayofWeek() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDayOfWeek(day);
    }

    public int countFoodType(FoodType foodType) {
        return (int) foods.stream().filter((food) -> food.getType() == foodType).count();
    }

    public boolean hasStar() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.hasStar(day);
    }
}


