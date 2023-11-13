package christmas.service.policy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.Menu;
import christmas.model.Reservation;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfWeekPolicyTest {

    @Test
    @DisplayName("평일 예약을 하여 디저트 할인을 받는다.")
    void getDiscountDessertMenu() {
        Map<Menu, Integer> foods = Map.of(Menu.CHOCO_CAKE, 2, Menu.CHRISTMAS_PASTA, 1);
        Reservation reservation = new Reservation(foods, 4);
        DiscountPolicy policy = new DayOfWeekPolicy();

        // when
        policy.calculatePrice(reservation);
        int 평일_할인 = reservation.getDiscountDetailsBy("평일 할인");

        // then
        assertEquals(평일_할인, 4046);
    }

    @Test
    @DisplayName("주말 예약을 하여 메인 메뉴 할인을 받는다.")
    void getDiscountMainMenu() {
        Map<Menu, Integer> foods = Map.of(Menu.CHOCO_CAKE, 2, Menu.CHRISTMAS_PASTA, 1);
        Reservation reservation = new Reservation(foods, 23);
        DiscountPolicy policy = new DayOfWeekPolicy();

        // when
        policy.calculatePrice(reservation);
        int 평일_할인 = reservation.getDiscountDetailsBy("주말 할인");

        // then
        assertEquals(평일_할인, 2023);
    }
}