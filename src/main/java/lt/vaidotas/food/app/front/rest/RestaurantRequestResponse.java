package lt.vaidotas.food.app.front.rest;

import java.util.Set;

public class RestaurantRequestResponse {

    private Integer id;
    private String name;
    private Set<MenuItemRequestResponse> menuItems;

    public RestaurantRequestResponse() {
    }

    public RestaurantRequestResponse(final Integer id, final String name, final Set<MenuItemRequestResponse> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
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

    public Set<MenuItemRequestResponse> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(final Set<MenuItemRequestResponse> menuItems) {
        this.menuItems = menuItems;
    }
}
