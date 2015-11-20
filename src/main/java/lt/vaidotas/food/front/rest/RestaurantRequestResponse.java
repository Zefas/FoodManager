package lt.vaidotas.food.front.rest;

import java.util.Set;

public class RestaurantRequestResponse {

    private String id;
    private String name;
    private Set<MenuItemRequestResponse> menuItems;

    public RestaurantRequestResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
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
