package christmas.service.policy;

import christmas.model.Reservation;

public class ChristmasDDayPolicy implements DiscountPolicy {

    private int startDay = 1;
    private int endDay = 25;
    private int baseDiscountPrice = 1000;
    private int dayPrice = 100;

    @Override
    public Reservation calculatePrice(Reservation reservation) {
        if (reservation.isContainDayRange(startDay, endDay)) {
            int discountPrice = calculateDiscountPrice(reservation.getChristmasDday());
            reservation.addDiscountType("크리스마스 디데이 할인", discountPrice);
        }
        return reservation;
    }

    private int calculateDiscountPrice(final int dDay) {
        return baseDiscountPrice + dayPrice * (endDay - dDay);
    }
}
