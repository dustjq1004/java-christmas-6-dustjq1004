package christmas.dto;

import christmas.model.Menu;
import christmas.service.event.BadgeEvent;
import java.util.List;
import java.util.Map;

public class ReservationDto {

    private Map<Menu, Integer> orders;
    private int totOrderAmount;
    private int totDiscountAmount;
    private int expectedAmount;
    private Map<String, Integer> discountDetails;
    private List<String> giveAway;
    private BadgeEvent badge;

    public Map<Menu, Integer> getOrders() {
        return orders;
    }

    public int getTotOrderAmount() {
        return totOrderAmount;
    }

    public int getTotDiscountAmount() {
        return totDiscountAmount;
    }

    public int getExpectedAmount() {
        return expectedAmount;
    }

    public Map<String, Integer> getDiscountDetails() {
        return discountDetails;
    }

    public List<String> getGiveAway() {
        return giveAway;
    }

    public BadgeEvent getBadge() {
        return badge;
    }

    public void setOrders(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void setTotOrderAmount(int totOrderAmount) {
        this.totOrderAmount = totOrderAmount;
    }

    public void setTotDiscountAmount(int totDiscountAmount) {
        this.totDiscountAmount = totDiscountAmount;
    }

    public void setExpectedAmount(int expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public void setDiscountDetails(Map<String, Integer> discountDetails) {
        this.discountDetails = discountDetails;
    }

    public void setGiveAway(List<String> giveAway) {
        this.giveAway = giveAway;
    }

    public void setBadge(BadgeEvent badge) {
        this.badge = badge;
    }
}
