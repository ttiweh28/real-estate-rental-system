package group3_real_estate_rental_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RealEstateRentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateRentalSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RealEstateRentalSystemApplication application) {
		return args -> {
			System.out.println("Welcome to RealEstateRentalSystem!");
		};
	}

}
