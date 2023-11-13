package christmas.dto;

import christmas.model.Menu;
import java.util.Map;

public class PreOrderDto {

    private int day;
    private Map<Menu, Integer> orders;

    public PreOrderDto(int day, Map<Menu, Integer> orders) {
        this.day = day;
        this.orders = orders;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setOrders(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public int getDay() {
        return day;
    }

    public Map<Menu, Integer> getOrders() {
        return orders;
    }
}
