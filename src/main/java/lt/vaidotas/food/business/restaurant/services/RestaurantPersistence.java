package lt.vaidotas.food.business.restaurant.services;

import lt.vaidotas.food.business.restaurant.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantPersistence {

    Optional<Restaurant> findById(Integer id);

    List<Restaurant> loadAll();

    void addNew(final Restaurant restaurant);

    void update(Restaurant restaurant);

}
