package lt.vaidotas.food.app.persistence.model;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VOTE")
public class VoteEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "TIME")
    private Date time;

    public VoteEntity() {
    }

    public VoteEntity(final Integer id, final Integer restaurantId, final Integer userId, final Date time) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("restaurant", restaurantId)
                .add("user", userId)
                .add("time", time)
                .toString();
    }
}
