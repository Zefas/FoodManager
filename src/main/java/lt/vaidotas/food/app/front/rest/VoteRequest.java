package lt.vaidotas.food.app.front.rest;

public class VoteRequest {
    private Integer userId;
    private Integer restaurantId;

    public VoteRequest() {
    }

    public VoteRequest(final Integer userId, final Integer restaurantId) {
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(final Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
