import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Booking.BookingRepository;
import group3_real_estate_rental_system.Booking.BookingServiceImpl;
import group3_real_estate_rental_system.Booking.BookingStatus;
import group3_real_estate_rental_system.User.entity.Admin;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.repository.AdminRepository;
import group3_real_estate_rental_system.User.repository.PropertyOwnerRepository;
import group3_real_estate_rental_system.User.repository.TenantRepository;
import group3_real_estate_rental_system.common.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RealEstateRentalSystemApplication implements CommandLineRunner {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private PropertyOwnerRepository propertyOwnerRepository;

	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@Autowired
	AdminRepository adminRepository;



	public static void main(String[] args) {
		SpringApplication.run(RealEstateRentalSystemApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to RealEstateRentalSystem");

		// Dummy data for Tenant
		Tenant tenant1 = new Tenant();
		tenant1.setFirstName("John");
		tenant1.setLastName("Doe");
		tenant1.setUserName("johndoe");
		tenant1.setPassword("password123");
		tenant1.setAddress(new Address("123 Main St", "New York", "NY", "10001","USA"));

		Tenant tenant2 = new Tenant();
		tenant2.setFirstName("Jane");
		tenant2.setLastName("Smith");
		tenant2.setUserName("janesmith");
		tenant2.setPassword("password456");
		tenant2.setAddress(new Address("456 Elm St", "Los Angeles", "CA", "90001","USA"));

		tenant1 = tenantRepository.save(tenant1);
		tenant2 = tenantRepository.save(tenant2);

		System.out.println("Dummy Tenants Created");

		// Dummy data for Booking
		Booking booking1 = new Booking();
		booking1.setTenant(tenant1);
		booking1.setBookingDate(LocalDateTime.now());
		booking1.setBookingStatus(BookingStatus.PENDING);

		Booking booking2 = new Booking();
		booking2.setTenant(tenant2);
		booking2.setBookingDate(LocalDateTime.now().plusDays(1));
		booking2.setBookingStatus(BookingStatus.PENDING);

		Booking booking3 = new Booking();
		booking3.setTenant(tenant2);
		booking3.setBookingDate(LocalDateTime.now().plusDays(1));
		booking3.setBookingStatus(BookingStatus.PENDING);

		bookingRepository.save(booking1);
		bookingRepository.save(booking2);
		bookingRepository.save(booking3);

		tenant1.addBooking(booking1);
		tenant2.addBooking(booking2);
		tenant2.addBooking(booking3);
//		tenantRepository.save(tenant1);
		System.out.println("Dummy Bookings Created");

//			//get bookings for a particular tenant
		List<Booking> bookings = bookingServiceImpl.getBookingByTenantId(tenant1.getUserId());
		System.out.println(bookings);
		bookings.stream().forEach(System.out::println);


			Address address1 = new Address("123 Main St", "New York", "NY", "10001", "USA");
			Address address2 = new Address("456 Elm St", "Los Angeles", "CA", "90001", "USA");
			Address address3 = new Address("789 Oak St", "Chicago", "IL", "60601", "USA");
			Address address4 = new Address("321 Maple St", "Washington", "DC", "20001", "USA");
			Address address5 = new Address("654 Pine St", "Boston", "MA", "02101", "USA");

			Admin admin1 = new Admin("Alice", "Johnson", "alice_admin", "securepass123", address1);
			Admin admin2 = new Admin("Bob", "Smith", "bob_admin", "admin@123", address2);
			Admin admin3 = new Admin("Charlie", "Brown", "charlie_admin", "password456", address3);
			Admin admin4 = new Admin("Diana", "Prince", "diana_admin", "wonderwoman", address4);
			Admin admin5 = new Admin("Ethan", "Hunt", "ethan_admin", "mi6topsecret", address5);

			adminRepository.saveAll(Arrays.asList(admin1, admin2, admin3, admin4, admin5));

			System.out.println("Dummy Admin data inserted successfully!");




	}

//	@Bean
//	CommandLineRunner commandLineRunner(PropertyOwnerRepository propertyOwnerRepository) {
//
//
//		return args -> {
//
//			///I used this for testing my DB, it can be commented out for other people to test
//			if (propertyOwnerRepository.count() < 100) {
//
//				// ✅ Create empty objects
//				PropertyOwner owner1 = new PropertyOwner();
//				PropertyOwner owner2 = new PropertyOwner();
//				PropertyOwner owner3 = new PropertyOwner();
//
//				// ✅ Set values using setters
//				owner1.setFirstName("Alice");
//				owner1.setLastName("Johnson");
//				owner1.setUserName("alicejohnson");
//				owner1.setPassword("password123");
//				owner1.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));
//
//
//				owner2.setFirstName("Bob");
//				owner2.setLastName("Smith");
//				owner2.setUserName("bobsmith");
//				owner2.setPassword("securepass");
//				owner2.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));
//
//
//				owner3.setFirstName("Charlie");
//				owner3.setLastName("Brown");
//				owner3.setUserName("charlieb");
//				owner3.setPassword("pass4321");
//				owner3.setAddress(new Address("123 Apple St", "New York", "NY", "10001", "USA"));
//
//
//				// ✅ Save dummy data to the database
//				propertyOwnerRepository.save(owner1);
//				propertyOwnerRepository.save(owner2);
//				propertyOwnerRepository.save(owner3);
//
//				System.out.println("✅ Dummy data added to the database using setters.");
//			} else {
//				System.out.println("✅ Database already contains data, skipping dummy data insertion.");
//			}
//
//
//
//			System.out.println("Welcome to RealEstateRentalSystem!");
//		};
//	}

}
