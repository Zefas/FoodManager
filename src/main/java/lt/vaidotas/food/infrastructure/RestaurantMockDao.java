package lt.vaidotas.food.infrastructure;

import lt.vaidotas.food.business.restaurant.model.Restaurant;
import lt.vaidotas.food.business.restaurant.services.RestaurantPersistence;
import lt.vaidotas.food.front.rest.RestaurantRequestResponse;

import java.util.List;

public class RestaurantMockDao implements RestaurantPersistence {
    @Override
    public List<RestaurantRequestResponse> loadAll() {
        return null;
    }

    @Override
    public void addNew(final Restaurant restaurant) {

    }

    @Override
    public void update(final Restaurant restaurant) {

    }
}
