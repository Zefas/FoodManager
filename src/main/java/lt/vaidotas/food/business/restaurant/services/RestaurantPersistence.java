package lt.vaidotas.food.business.restaurant.services;

import lt.vaidotas.food.business.restaurant.model.Restaurant;
import lt.vaidotas.food.front.rest.RestaurantRequestResponse;

import java.util.List;

public interface RestaurantPersistence {

    List<RestaurantRequestResponse> loadAll();

    void addNew(final Restaurant restaurant);

    void update(Restaurant restaurant);

}
