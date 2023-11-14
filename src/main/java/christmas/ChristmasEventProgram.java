package christmas;

import christmas.controller.OrderController;
import christmas.dto.ReservationConfirm;
import christmas.model.Order;
import christmas.model.PreOrder;
import christmas.utils.OrderGenerator;
import christmas.utils.StringConverter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventProgram {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderController orderController;

    public ChristmasEventProgram(InputView inputView, OutputView outputView, OrderController orderController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderController = orderController;
    }

    public void run() {
        outputView.printNotification();
        int clientReservationDate = getClientReservationDate();
        Order clientOrder = getClientOrder();
        PreOrder preOrder = new PreOrder(clientReservationDate, clientOrder);
        ReservationConfirm reservationConfirm = orderController.reserveOrder(preOrder);
        printResultReservation(reservationConfirm);
    }

    private Order getClientOrder() {
        Order clientOrder = OrderGenerator.generateOrder(inputView.readOrder());
        return clientOrder;
    }

    private int getClientReservationDate() {
        int clientReservationDate = StringConverter.convertToInteger(inputView.readDate());
        return clientReservationDate;
    }

    private void printResultReservation(ReservationConfirm reservationConfirm) {
        outputView.printReservationConfirm(reservationConfirm);
    }
}
