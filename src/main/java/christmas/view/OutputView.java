package christmas.view;

import christmas.dto.ReservationDto;

public class OutputView {

    public void printNotification() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n");
        System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.\n"
                + "음료만 주문 시, 주문할 수 없습니다.\n"
                + "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
                + "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)\n");
    }

    public void printReservationConfirm(ReservationDto reservationDto) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        System.out.println("<주문 메뉴>");
        reservationDto.getOrders().forEach((food, count) -> {
            System.out.println(String.format("%s %d개", food.getName(), count));
        });
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원\n", reservationDto.getTotOrderAmount()));
        System.out.println("<증정 메뉴>");
        reservationDto.getGiveAway().forEach((giveAway) -> System.out.println(String.format("%s 1개", giveAway)));
        System.out.println();
        System.out.println("<혜택 내역>");
        reservationDto.getDiscountDetails().forEach((discountName, amount) ->
                System.out.println(String.format("%s: -%,d원", discountName, amount)
                ));
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("-%,d원\n", reservationDto.getTotDiscountAmount()));
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원\n", reservationDto.getExpectedAmount()));
        System.out.println("<12월 이벤트 배지>");
        System.out.println(reservationDto.getBadge().getName());
    }
}
/*
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!

<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개

<할인 전 총주문 금액>
142,000원

<증정 메뉴>
샴페인 1개

<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원

<총혜택 금액>
-31,246원

<할인 후 예상 결제 금액>
135,754원

<12월 이벤트 배지>
산타
* */