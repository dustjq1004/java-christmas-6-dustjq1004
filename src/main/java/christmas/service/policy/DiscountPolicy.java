package christmas.service.policy;

import christmas.model.Reservation;

public interface DiscountPolicy {
    public Reservation calculatePrice(Reservation reservation);
}
