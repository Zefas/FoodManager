package lt.vaidotas.food.business.voting.model;

import lt.vaidotas.food.business.restaurant.model.Restaurant;

public class VoteResult {

    private final Restaurant restaurant;
    private final Long count;

    public VoteResult(final Restaurant restaurant, final Long count) {
        this.restaurant = restaurant;
        this.count = count;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Long getCount() {
        return count;
    }
}
