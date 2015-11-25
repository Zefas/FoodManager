package lt.vaidotas.food.app.persistence;

import com.google.common.collect.Lists;
import lt.vaidotas.food.app.persistence.mappers.RestaurantPersistenceMapper;
import lt.vaidotas.food.app.persistence.model.RestaurantEntity;
import lt.vaidotas.food.app.persistence.repository.RestaurantRepository;
import lt.vaidotas.food.business.restaurant.model.Restaurant;
import lt.vaidotas.food.business.restaurant.services.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RestaurantPersistenceImpl implements RestaurantPersistence {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantPersistenceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Restaurant> loadAll() {
        Collection<Restaurant> restaurants = mapper.to(Lists.newArrayList(restaurantRepository.findAll()));
        return new ArrayList<>(restaurants);
    }

    @Override
    @Transactional
    public void addNew(Restaurant restaurant) {
        saveOrUpdate(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
        saveOrUpdate(restaurant);
    }

    private void saveOrUpdate(Restaurant restaurant) {
        RestaurantEntity entity = mapper.from(restaurant);
        restaurantRepository.save(entity);
    }
}
