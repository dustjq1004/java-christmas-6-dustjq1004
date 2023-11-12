package christmas.service.policy;

import christmas.model.Reservation;

public class SpecialPolicy implements DiscountPolicy {

    private int startDay = 1;
    private int endDay = 31;
    private int baseDiscountPrice = 1000;

    @Override
    public Reservation calculatePrice(Reservation reservation) {
        if (reservation.hasStar() && reservation.isContainDayRange(startDay, endDay)) {
            reservation.addDiscountType("특별 할인", baseDiscountPrice);
        }
        return reservation;
    }
}
