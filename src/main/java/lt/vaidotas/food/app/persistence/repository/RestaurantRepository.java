package lt.vaidotas.food.app.persistence.repository;

import lt.vaidotas.food.app.persistence.model.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Integer> {

}
