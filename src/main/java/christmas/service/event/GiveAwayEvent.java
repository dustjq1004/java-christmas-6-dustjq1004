package christmas.service.event;

import christmas.model.Menu;
import christmas.model.PreOrder;
import christmas.model.Reservation;

public class GiveAwayEvent {

    private final Menu GIFT = Menu.CHAMPAGNE;
    private final int BASE_PRICE = 120_000;


    public void receiveGiveAwayIfConfirm(PreOrder preOrder, Reservation reservation) {
        if (confirmGiveAwayEvent(preOrder, reservation)) {
            reservation.addDiscountType("증정 이벤트", -GIFT.getPrice());
            reservation.addGiveAway(GIFT.getName());
        }
    }

    private boolean confirmGiveAwayEvent(PreOrder preOrder, Reservation reservation) {
        return preOrder.getTotalOrderPrice() >= BASE_PRICE;
    }
}
