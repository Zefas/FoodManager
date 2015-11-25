package lt.vaidotas.food.app.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepositoryVerificationService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Transactional
    public void printInitialData() {
        System.err.println("Checking if DB is initialized.");
        restaurantRepository.findAll().forEach(r -> {
            System.err.println(r);
            System.err.println(r.getMenuItems());
        });
        System.err.println(voteRepository.findAll());
    }
}
