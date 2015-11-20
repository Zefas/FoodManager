package lt.vaidotas.food.business.restaurant.model;

public class MenuItem {
    private final String name;
    private final Integer price;

    public MenuItem(final String name, final Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
