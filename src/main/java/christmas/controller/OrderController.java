package christmas.controller;

import christmas.dto.PreOrderDto;
import christmas.dto.ReservationDto;
import christmas.model.Reservation;
import christmas.service.DiscountPolicyService;

public class OrderController {

    private final DiscountPolicyService discountPolicyService;

    public OrderController(DiscountPolicyService discountPolicyService) {
        this.discountPolicyService = discountPolicyService;
    }

    public ReservationDto reserveOrder(PreOrderDto preOrderDto) {
        Reservation reservation = new Reservation(preOrderDto.getOrders(), preOrderDto.getDay());
        discountPolicyService.calculateDiscountPriceByPolicy(reservation);
        ReservationDto reservationDto = reservation.toReservationDto(reservation);
        return reservationDto;
    }
}
