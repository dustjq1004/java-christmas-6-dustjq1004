package christmas.model;

import christmas.dto.ReservationDto;
import christmas.service.event.BadgeEvent;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    private Map<Menu, Integer> orders;
    private final int day;
    private final Map<String, Integer> discountDetails;
    private final List<String> giveAways;

    public Reservation(Map<Menu, Integer> orders, int day) {
        this.orders = orders;
        this.day = day;
        discountDetails = new HashMap<>();
        giveAways = new ArrayList<>();
    }

    public ReservationDto toReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setOrders(this.orders);
        reservationDto.setDiscountDetails(this.discountDetails);
        reservationDto.setTotOrderAmount(getTotalPrice());
        reservationDto.setExpectedAmount(getTotalPrice() - getTotalDiscountedPrice());
        reservationDto.setTotDiscountAmount(getTotalDiscountedPrice());
        reservationDto.setBadge(getBadge());
        reservationDto.setGiveAway(giveAways);
        return reservationDto;
    }

    public void addDiscountType(String name, int price) {
        discountDetails.put(name, price);
    }

    public boolean isContainDayRange(final int startDay, final int endDay) {
        return startDay <= day && day <= endDay;
    }

    public int getChristmasDday() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDDayChristmas(day);
    }

    public DayOfWeek getDayofWeek() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.getDayOfWeek(day);
    }

    public int countFoodType(FoodType foodType) {
        return orders.keySet().stream()
                .filter((food) -> food.getType() == foodType)
                .mapToInt((food) -> orders.get(food))
                .sum();
    }

    public boolean hasStar() {
        EventCalendar eventCalendar = new EventCalendar();
        return eventCalendar.hasStar(day);
    }

    public int getTotalPrice() {
        return orders.keySet().stream().mapToInt((food) ->
                food.getPrice() * orders.get(food)
        ).sum();
    }

    public int getTotalDiscountedPrice() {
        return discountDetails.values()
                .stream()
                .mapToInt((price) -> price)
                .sum();
    }

    public BadgeEvent getBadge() {
        return BadgeEvent.getEventBadgeIfPrice(getTotalPrice());
    }

    public int getDiscountDetailsBy(String discountName) {
        Integer price = discountDetails.get(discountName);
        if (price == null) {
            return 0;
        }
        return price;
    }

    public void addGiveAway(String name) {
        giveAways.add(name);
    }
}