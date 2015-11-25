package lt.vaidotas.food.business.restaurant.model;

import java.util.Objects;
import java.util.Set;

public class Restaurant {

    private final Integer id;
    private final String name;
    private final Set<MenuItem> menuItems;

    public Restaurant(final Integer id, final String name, final Set<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
