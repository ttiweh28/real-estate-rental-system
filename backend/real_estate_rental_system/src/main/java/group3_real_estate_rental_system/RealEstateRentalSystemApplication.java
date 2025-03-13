package group3_real_estate_rental_system;

import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.repository.PropertyOwnerRepository;
import group3_real_estate_rental_system.common.Address;
import org.springframework.beans.factory.annotation.Autowired;
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
	CommandLineRunner commandLineRunner(PropertyOwnerRepository propertyOwnerRepository) {


		return args -> {

			///I used this for testing my DB, it can be commented out for other people to test
			if (propertyOwnerRepository.count() < 100) {

				// ✅ Create empty objects
				PropertyOwner owner1 = new PropertyOwner();
				PropertyOwner owner2 = new PropertyOwner();
				PropertyOwner owner3 = new PropertyOwner();

				// ✅ Set values using setters
				owner1.setFirstName("Alice");
				owner1.setLastName("Johnson");
				owner1.setUserName("alicejohnson");
				owner1.setPassword("password123");
				owner1.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));


				owner2.setFirstName("Bob");
				owner2.setLastName("Smith");
				owner2.setUserName("bobsmith");
				owner2.setPassword("securepass");
				owner2.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));


				owner3.setFirstName("Charlie");
				owner3.setLastName("Brown");
				owner3.setUserName("charlieb");
				owner3.setPassword("pass4321");
				owner3.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));


				// ✅ Save dummy data to the database
				propertyOwnerRepository.save(owner1);
				propertyOwnerRepository.save(owner2);
				propertyOwnerRepository.save(owner3);

				System.out.println("✅ Dummy data added to the database using setters.");
			} else {
				System.out.println("✅ Database already contains data, skipping dummy data insertion.");
			}



			System.out.println("Welcome to RealEstateRentalSystem!");
		};
	}

}
