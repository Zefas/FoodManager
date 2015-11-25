package lt.vaidotas.food.business.restaurant.services;

import lt.vaidotas.food.business.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantPersistence {

    List<Restaurant> loadAll();

    void addNew(final Restaurant restaurant);

    void update(Restaurant restaurant);

}
