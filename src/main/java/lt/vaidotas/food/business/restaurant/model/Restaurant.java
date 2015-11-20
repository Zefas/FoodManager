package lt.vaidotas.food.business.restaurant.model;

import java.util.Set;

public class Restaurant {

    private final String id;
    private final String name;
    private final Set<MenuItem> menuItems;

    public Restaurant(final String id, final String name, final Set<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }
}
