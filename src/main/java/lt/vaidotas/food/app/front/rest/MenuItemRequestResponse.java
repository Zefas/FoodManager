package lt.vaidotas.food.app.front.rest;

public class MenuItemRequestResponse {
    private Integer id;
    private String name;
    private Integer price;

    public MenuItemRequestResponse() {
    }

    public MenuItemRequestResponse(final Integer id, final String name, final Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
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
