package christmas.service.policy;

import christmas.model.FoodType;
import christmas.model.Reservation;
import java.time.DayOfWeek;
import java.util.List;

public class DayOfWeekPolicy implements DiscountPolicy {

    private int startDay = 1;
    private int endDay = 31;
    private int baseDiscountPrice = 2023;

    @Override
    public Reservation calculatePrice(Reservation reservation) {
        if (!reservation.isContainDayRange(startDay, endDay)) {
            return reservation;
        }
        FoodType foodType = selectFoodTypeIfDayOfWeek(reservation.getDayofWeek());
        int count = reservation.countFoodType(foodType);
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
