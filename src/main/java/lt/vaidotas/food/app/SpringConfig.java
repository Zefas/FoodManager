package lt.vaidotas.food.app;

import lt.vaidotas.food.app.persistence.RestaurantPersistenceImpl;
import lt.vaidotas.food.app.persistence.VotePersistenceImpl;
import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.restaurant.RestaurantManager;
import lt.vaidotas.food.business.voting.VoteManager;
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

    @Bean
    public VoteManager voteManager() {
        return new VoteManager(new VotePersistenceImpl(), new TimeCalculator());
    }

    @Bean
    public RestaurantManager restaurantManager() {
        return new RestaurantManager(new RestaurantPersistenceImpl());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
