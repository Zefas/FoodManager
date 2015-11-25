package lt.vaidotas.food.app.front.mappers;

import lt.vaidotas.food.app.front.rest.MenuItemRequestResponse;
import lt.vaidotas.food.app.front.rest.RestaurantRequestResponse;
import lt.vaidotas.food.app.generic.Mapper;
import lt.vaidotas.food.business.restaurant.model.MenuItem;
import lt.vaidotas.food.business.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper implements Mapper<RestaurantRequestResponse, Restaurant> {

    @Override
    public Restaurant to(RestaurantRequestResponse from) {
        return new Restaurant(from.getId(), from.getName(), mapMenuItemsReq(from.getMenuItems()));
    }

    @Override
    public RestaurantRequestResponse from(final Restaurant to) {
        return new RestaurantRequestResponse(to.getId(), to.getName(), mapMenuItems(to.getMenuItems()));
    }

    private Set<MenuItem> mapMenuItemsReq(final Set<MenuItemRequestResponse> menuItems) {
        Set<MenuItem> items = menuItems.stream()
                .map(req -> new MenuItem(req.getId(), req.getName(), req.getPrice()))
                .collect(Collectors.toSet());
        return new HashSet<>(items);
    }

    private Set<MenuItemRequestResponse> mapMenuItems(final Set<MenuItem> menuItems) {
        return menuItems.stream()
                .map(m -> new MenuItemRequestResponse(m.getId(), m.getName(), m.getPrice()))
                .collect(Collectors.toSet());
    }

}
