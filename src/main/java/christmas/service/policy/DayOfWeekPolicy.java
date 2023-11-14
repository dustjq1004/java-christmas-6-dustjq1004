package christmas.service.policy;

import christmas.model.FoodType;
import christmas.model.PreOrder;
import christmas.model.Reservation;
import java.time.DayOfWeek;
import java.util.List;

public class DayOfWeekPolicy implements DiscountPolicy {

    private int startDay = 1;
    private int endDay = 31;
    private int baseDiscountPrice = 2023;

    @Override
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation) {
        if (!preOrder.isContainDayRange(startDay, endDay)) {
            return reservation;
        }
        FoodType foodType = selectFoodTypeIfDayOfWeek(preOrder.getDayofWeek());
        int count = preOrder.getTotalCountOfFoodType(foodType);
        int discountPrice = baseDiscountPrice * count;

        if (foodType == FoodType.MAIN) {
            reservation.addDiscountType("주말 할인", discountPrice);
            return reservation;
        }
        reservation.addDiscountType("평일 할인", discountPrice);
        return reservation;
    }

    private FoodType selectFoodTypeIfDayOfWeek(DayOfWeek dayOfWeek) {
        List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        if (dayOfWeeks.contains(dayOfWeek)) {
            return FoodType.MAIN;
        }
        return FoodType.DESERT;
    }
}
