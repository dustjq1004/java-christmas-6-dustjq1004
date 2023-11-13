package christmas.service.policy;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import christmas.model.Menu;
import christmas.model.Reservation;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChristmasDDayPolicyTest {

    @ParameterizedTest
    @MethodSource("reservationDayProvider")
    @DisplayName("예약한 날짜는 day이고 할인 금액은 discoutnPrice이다.")
    void ChristmasDDayPolicyTest1(int day, int discountPrice) {
        DiscountPolicy discountPolicy = new ChristmasDDayPolicy();
        Map<Menu, Integer> foods = Map.of(Menu.CHRISTMAS_PASTA, 1, Menu.BUTTON_MUSHROOM_SOUP, 1);
        Reservation reservation = new Reservation(foods, day);

        //when
        discountPolicy.calculatePrice(reservation);
        int 크리스마스_디데이_할인 = reservation.getDiscountDetailsBy("크리스마스 디데이 할인");

        //then
        Assertions.assertThat(크리스마스_디데이_할인).isEqualTo(discountPrice);
    }

    static Stream<Arguments> reservationDayProvider() {
        return Stream.of(
                arguments(2, 1100),
                arguments(3, 1200),
                arguments(4, 1300),
                arguments(5, 1400),
                arguments(6, 1500),
                arguments(7, 1600),
                arguments(8, 1700),
                arguments(25, 3400),
                arguments(26, 0)
        );
    }
}