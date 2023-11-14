package christmas.controller;

import christmas.dto.ReservationConfirm;
import christmas.model.PreOrder;
import christmas.model.Reservation;
import christmas.service.DiscountPolicyService;

public class OrderController {

    private final DiscountPolicyService discountPolicyService;

    public OrderController(DiscountPolicyService discountPolicyService) {
        this.discountPolicyService = discountPolicyService;
    }

    public ReservationConfirm reserveOrder(PreOrder preOrder) {
        Reservation reservation = new Reservation();
        discountPolicyService.calculateDiscountPriceByPolicy(preOrder, reservation);
        int totalOrderPrice = preOrder.getTotalOrderPrice();
        int totalDiscountedPrice = reservation.getTotalDiscountedPrice();
        int expectedAmount = totalOrderPrice - totalDiscountedPrice;
        return new ReservationConfirm(
                preOrder.getOrederMap(),
                totalOrderPrice,
                totalDiscountedPrice,
                expectedAmount,
                reservation.getDiscountDetails(),
                reservation.getGiveAways(),
                reservation.getBadge()
        );
    }
}
