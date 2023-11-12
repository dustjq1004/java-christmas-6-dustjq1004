package christmas.service.policy;

import christmas.model.Menu;
import christmas.model.Reservation;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialPolicyTest {

    @Test
    @DisplayName("날짜 정보에 따라서 특별 할인을 받는다.")
    void successSpecialDiscountTest() {
        // given
        Reservation reservation = new Reservation(List.of(Menu.BARBECUE_RIBS, Menu.CHRISTMAS_PASTA), 24);
        DiscountPolicy discountPolicy = new SpecialPolicy();

        // when
        discountPolicy.calculatePrice(reservation);
        int discountPrice = reservation.getDiscountDetailsBy("특별 할인");

        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("날짜 정보에 따라서 특별 할인을 받지 못한다.")
    void failSpecialDiscountTest() {
        // given
        Reservation reservation = new Reservation(List.of(Menu.BARBECUE_RIBS, Menu.CHRISTMAS_PASTA), 13);
        DiscountPolicy discountPolicy = new SpecialPolicy();

        // when
        discountPolicy.calculatePrice(reservation);
        int discountPrice = reservation.getDiscountDetailsBy("특별 할인");

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}