package christmas.view;

import christmas.dto.ReservationConfirm;
import christmas.model.Menu;
import christmas.service.event.BadgeEvent;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printNotification() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n");
        System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.\n"
                + "음료만 주문 시, 주문할 수 없습니다.\n"
                + "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
                + "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)\n");
    }

    public void printReservationConfirm(ReservationConfirm reservationConfirm) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        printOrderedMenus(reservationConfirm.order());
        printTotalOrderAmount(reservationConfirm.totDiscountAmount());
        printGiveaways(reservationConfirm.giveAway());
        System.out.println();
        printDiscountDetails(reservationConfirm.discountDetails());
        System.out.println();
        printDiscountAmount(reservationConfirm.totDiscountAmount());
        printExpectedAmount(reservationConfirm.expectedAmount());
        printBadge(reservationConfirm.badge());
    }

    private void printOrderedMenus(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach((food, count) -> {
            System.out.println(String.format("%s %d개", food.getName(), count));
        });
        System.out.println();
    }

    private void printTotalOrderAmount(int totOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원\n", totOrderAmount));
    }

    private void printGiveaways(List<String> givenAway) {
        System.out.println("<증정 메뉴>");
        if (givenAway.isEmpty()) {
            System.out.println("없음");
            return;
        }
        givenAway.forEach((giveAway) -> System.out.println(String.format("%s 1개", giveAway)));
    }

    private void printDiscountDetails(Map<String, Integer> discountDetails) {
        System.out.println("<혜택 내역>");
        if (discountDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }
        discountDetails.forEach((discountName, amount) ->
                System.out.println(String.format("%s: %,d원", discountName, amount)
                ));
    }

    private void printDiscountAmount(int totDiscountAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("%,d원\n", totDiscountAmount));
    }

    private void printExpectedAmount(int expectedAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원\n", expectedAmount));
    }

    private void printBadge(BadgeEvent badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getName());
    }
}
