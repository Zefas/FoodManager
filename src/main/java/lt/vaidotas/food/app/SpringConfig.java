package lt.vaidotas.food.app;

import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.restaurant.RestaurantManager;
import lt.vaidotas.food.business.voting.VoteManager;
import lt.vaidotas.food.infrastructure.RestaurantMockDao;
import lt.vaidotas.food.infrastructure.VotePersistenceMockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("lt.vaidotas.food")
public class SpringConfig {

    @Bean
    public VoteManager voteManager() {
        return new VoteManager(new VotePersistenceMockService(), new TimeCalculator());
    }

    @Bean
    public RestaurantManager restaurantManager() {
        return new RestaurantManager(new RestaurantMockDao());
    }

}
