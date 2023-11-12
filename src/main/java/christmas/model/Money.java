package christmas.model;

public class Money {

    private int money;

    public Money(final int money) {
        this.money = money;
    }

    public Money minus(final int discountPrice) {
        money -= discountPrice;
        return this;
    }

    public int getMoney() {
        return money;
    }
}
