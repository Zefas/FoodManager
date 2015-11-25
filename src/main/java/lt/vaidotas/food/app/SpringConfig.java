package lt.vaidotas.food.app;

import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.restaurant.RestaurantManager;
import lt.vaidotas.food.business.restaurant.services.RestaurantPersistence;
import lt.vaidotas.food.business.voting.VoteManager;
import lt.vaidotas.food.business.voting.services.VotePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("lt.vaidotas.food")
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private RestaurantPersistence restaurantPersistence;

    @Autowired
    private VotePersistence votePersistence;


    @Bean
    public VoteManager voteManager() {
        return new VoteManager(votePersistence, restaurantPersistence, new TimeCalculator());
    }

    @Bean
    public RestaurantManager restaurantManager() {
        return new RestaurantManager(restaurantPersistence);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
