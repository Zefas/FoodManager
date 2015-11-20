package lt.vaidotas.food.business.voting.model;

import java.time.LocalDateTime;

public class Vote {
    public final Integer userId;
    public final Integer restaurantId;
    public final LocalDateTime dateAndTime;

    public Vote(final Integer userId, final Integer restaurantId, final LocalDateTime dateAndTime) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.dateAndTime = dateAndTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}
