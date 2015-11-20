package lt.vaidotas.food.business.restaurant;

import lt.vaidotas.food.business.restaurant.model.Restaurant;
import lt.vaidotas.food.business.restaurant.services.RestaurantPersistence;
import lt.vaidotas.food.business.voting.BusinessValidationException;
import lt.vaidotas.food.front.rest.RestaurantRequestResponse;

import java.util.List;

public class RestaurantManager {

    private final RestaurantPersistence restaurantPersistence;

    public RestaurantManager(final RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistence = restaurantPersistence;
    }

    public List<RestaurantRequestResponse> getAllRestaurants() {
        return restaurantPersistence.loadAll();
    }

    public void addNewRestaurant(final Restaurant restaurant) throws BusinessValidationException {
        restaurantPersistence.addNew(restaurant);
    }

    public void updateRestaurant(final Restaurant restaurant) throws BusinessValidationException {
        restaurantPersistence.update(restaurant);
    }

}
