package christmas.model;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {

    @Test
    @DisplayName("주문한 메뉴에는 메인 메뉴인 음식이 3개 있다.")
    void ThreeCountMainMenu() {
        Map<Menu, Integer> orders = Map.of(Menu.T_BONE_STEAK, 3, Menu.CHAMPAGNE, 1);
        Reservation reservation = new Reservation(orders, 23);

        // when & then
        Assertions.assertThat(reservation.countFoodType(FoodType.MAIN)).isEqualTo(3);
    }

    @Test
    @DisplayName("주문한 메뉴에는 음료 메뉴인 음식이 1개 있다.")
    void OneCountDrinkMenu() {
        Map<Menu, Integer> orders = Map.of(Menu.T_BONE_STEAK, 3, Menu.CHAMPAGNE, 1);
        Reservation reservation = new Reservation(orders, 23);

        // when & then
        Assertions.assertThat(reservation.countFoodType(FoodType.DRINK)).isEqualTo(1);
    }


}