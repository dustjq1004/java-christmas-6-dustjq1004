package christmas.model;

import christmas.service.event.BadgeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    private final Map<String, Integer> discountDetails;
    private final List<String> giveAways;

    public Reservation() {
        this.discountDetails = new HashMap<>();
        this.giveAways = new ArrayList<>();
    }

    public void addDiscountType(String name, int price) {
        discountDetails.put(name, price);
    }

    public int getTotalDiscountedPrice() {
        return discountDetails.values()
                .stream()
                .mapToInt((price) -> price)
                .sum();
    }

    public BadgeEvent getBadge() {
        return BadgeEvent.getEventBadgeIfPrice(getTotalDiscountedPrice());
    }

    public int getDiscountDetailsBy(String discountName) {
        return discountDetails.get(discountName);
    }

    public void addGiveAway(String name) {
        giveAways.add(name);
    }

    public Map<String, Integer> getDiscountDetails() {
        return discountDetails;
    }

    public List<String> getGiveAways() {
        return giveAways;
    }
}