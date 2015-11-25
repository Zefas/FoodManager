package lt.vaidotas.food.business.restaurant.model;

public class MenuItem {
    private final Integer id;
    private final String name;
    private final Integer price;

    public MenuItem(Integer id, final String name, final Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
