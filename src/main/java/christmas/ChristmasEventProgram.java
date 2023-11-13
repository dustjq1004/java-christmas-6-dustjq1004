package christmas;

import christmas.controller.OrderController;
import christmas.dto.PreOrderDto;
import christmas.dto.ReservationDto;
import christmas.model.Menu;
import christmas.utils.StringConverter;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasEventProgram {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderController orderController;

    public ChristmasEventProgram(InputView inputView, OutputView outputView, OrderController orderController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderController = orderController;
    }

    public void start() {
        outputView.printNotification();
        int clientReservationDate = StringConverter.convertToInteger(getClientReservationDate());
        Map<Menu, Integer> clientOrder = StringConverter.convertOrderToMap(getClientOrder());
        PreOrderDto preOrderDto = new PreOrderDto(clientReservationDate, clientOrder);
        ReservationDto reservationDto = orderController.reserveOrder(preOrderDto);
        printResultReservation(reservationDto);
    }

    private String getClientOrder() {
        return inputView.readOrder();
    }

    private String getClientReservationDate() {
        return inputView.readDate();
    }

    private void printResultReservation(ReservationDto reservationDto) {
        outputView.printReservationConfirm(reservationDto);
    }
}
