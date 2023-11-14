package christmas.service.policy;

import christmas.model.PreOrder;
import christmas.model.Reservation;

public interface DiscountPolicy {
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation);
}
