package lt.vaidotas.food.app.persistence.mappers;

import lt.vaidotas.food.app.generic.Mapper;
import lt.vaidotas.food.app.persistence.model.MenuItemEntity;
import lt.vaidotas.food.app.persistence.model.RestaurantEntity;
import lt.vaidotas.food.business.restaurant.model.MenuItem;
import lt.vaidotas.food.business.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RestaurantPersistenceMapper implements Mapper<RestaurantEntity, Restaurant> {

    @Override
    public Restaurant to(RestaurantEntity from) {
        return new Restaurant(from.getId(), from.getName(), mapMenuItems(from.getMenuItems()));
    }

    @Override
    public RestaurantEntity from(Restaurant to) {
        RestaurantEntity restaurantEntity = new RestaurantEntity(to.getId(), to.getName(), Collections.emptySet());
        restaurantEntity.setMenuItems(mapMenuItems(to.getMenuItems(), restaurantEntity));
        return restaurantEntity;
    }

    private Set<MenuItemEntity> mapMenuItems(Set<MenuItem> menuItems, RestaurantEntity restaurant) {
        return menuItems.stream()
                .map(m -> new MenuItemEntity(m.getId(), m.getName(), m.getPrice(), restaurant))
                .collect(Collectors.toSet());
    }

    private Set<MenuItem> mapMenuItems(Set<MenuItemEntity> menuItems) {
        return menuItems.stream()
                .map(entity -> new MenuItem(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toSet());
    }

}
