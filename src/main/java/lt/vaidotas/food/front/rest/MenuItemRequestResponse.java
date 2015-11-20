package lt.vaidotas.food.front.rest;

public class MenuItemRequestResponse {
    private String name;
    private Integer price;

    public MenuItemRequestResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }
}
