package lt.vaidotas.food.business.voting.model;

import lt.vaidotas.food.business.restaurant.model.Restaurant;

public class VoteResult {

    private final Restaurant restaurant;
    private final Integer count;

    public VoteResult(final Restaurant restaurant, final Integer count) {
        this.restaurant = restaurant;
        this.count = count;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Integer getCount() {
        return count;
    }
}
