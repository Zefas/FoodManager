package lt.vaidotas.food.front.controllers;

import lt.vaidotas.food.business.restaurant.model.MenuItem;
import lt.vaidotas.food.business.restaurant.model.Restaurant;
import lt.vaidotas.food.front.rest.MenuItemRequestResponse;
import lt.vaidotas.food.front.rest.RestaurantRequestResponse;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    public Restaurant mapTo(final RestaurantRequestResponse data) {
        return new Restaurant(data.getId(), data.getName(), mapMenuItems(data.getMenuItems()));
    }

    public Set<Restaurant> mapToCollection(final Set<RestaurantRequestResponse> data) {
        Set<Restaurant> restaurants = data.stream()
                .map(this::mapTo)
                .collect(Collectors.toSet());
        return new HashSet<>(restaurants);
    }

    private Set<MenuItem> mapMenuItems(final Set<MenuItemRequestResponse> menuItems) {
        Set<MenuItem> items = menuItems.stream()
                .map(req -> new MenuItem(req.getName(), req.getPrice()))
                .collect(Collectors.toSet());
        return new HashSet<>(items);
    }

}
