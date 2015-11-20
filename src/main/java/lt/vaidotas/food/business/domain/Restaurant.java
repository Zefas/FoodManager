package lt.vaidotas.food.business.domain;

import java.util.Set;

public class Restaurant {

    private String id;
    private String name;
    private Set<MenuItem> menuItems;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(final Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
