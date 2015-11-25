package lt.vaidotas.food.app;


import lt.vaidotas.food.app.persistence.repository.RepositoryVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodManagerApplication implements CommandLineRunner {

    @Autowired
    private RepositoryVerificationService repositoryVerificationService;

    @Override
    public void run(String... strings) throws Exception {
        repositoryVerificationService.printInitialData();
    }

    public static void main(String[] args) {
        SpringApplication.run(FoodManagerApplication.class, args);
    }

}
