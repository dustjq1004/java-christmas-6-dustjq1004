package christmas.service.policy;

import christmas.model.PreOrder;
import christmas.model.Reservation;

public class SpecialPolicy implements DiscountPolicy {

    private int startDay = 1;
    private int endDay = 31;
    private int baseDiscountPrice = 1000;

    @Override
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation) {
        if (preOrder.hasStar() && preOrder.isContainDayRange(startDay, endDay)) {
            reservation.addDiscountType("특별 할인", baseDiscountPrice);
        }
        return reservation;
    }
}
