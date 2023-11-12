package christmas.service.event;

import christmas.model.Menu;
import christmas.model.Reservation;

public class GiveAwayEvent {

    private final Menu GIFT = Menu.CHAMPAGNE;
    private final int BASE_PRICE = 120_000;


    public void receiveGiveAwayIfConfirm(Reservation reservation) {
        if (confirmGiveAwayEvent(reservation)) {
            reservation.addDiscountType("증정 이벤트", GIFT.getPrice());
        }
    }

    private boolean confirmGiveAwayEvent(Reservation reservation) {
        return reservation.getTotalPrice() >= BASE_PRICE;
    }
}
