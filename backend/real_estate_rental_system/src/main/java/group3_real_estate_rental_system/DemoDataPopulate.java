package group3_real_estate_rental_system;

import group3_real_estate_rental_system.Booking.BookingRepository;
import group3_real_estate_rental_system.Booking.BookingService;
import group3_real_estate_rental_system.Booking.BookingStatus;
import group3_real_estate_rental_system.Booking.dto.BookingDTO;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.User.entity.Admin;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.repository.AdminRepository;
import group3_real_estate_rental_system.User.repository.TenantRepository;
import group3_real_estate_rental_system.User.service.AdminService;
import group3_real_estate_rental_system.User.service.TenantService;
import group3_real_estate_rental_system.common.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Profile("dev")
@Configuration
public class DemoDataPopulate {

    //FIX it
    //TODO
    TenantRepository tenantRepository;
    AdminRepository adminRepository;
    BookingRepository bookingRepository;
    TenantService tenantService;

    BookingService bookingService;
    AdminService adminService;

    public DemoDataPopulate(TenantRepository tenantRepository, AdminRepository adminRepository, BookingRepository bookingRepository, TenantService tenantService, BookingService bookingService, AdminService adminService) {
        this.tenantRepository = tenantRepository;
        this.adminRepository = adminRepository;
        this.bookingRepository = bookingRepository;
        this.tenantService = tenantService;
        this.bookingService = bookingService;
        this.adminService = adminService;
    }

    @Transactional
    @Bean
    public Object dataPopulate() {
        System.out.println("Welcome to RealEstateRentalSystem");

        // Dummy data for Tenant
        Tenant tenant1 = new Tenant();
        tenant1.setFirstName("John");
        tenant1.setLastName("Doe");
        tenant1.setUserName("johndoe");
        tenant1.setPassword("password123");
        tenant1.setAddress(new Address("123 Main St", "New York", "NY", "10001", "USA"));

        Tenant tenant2 = new Tenant();
        tenant2.setFirstName("Jane");
        tenant2.setLastName("Smith");
        tenant2.setUserName("janesmith");
        tenant2.setPassword("password456");
        tenant2.setAddress(new Address("456 Elm St", "Los Angeles", "CA", "90001", "USA"));

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
        List<BookingDTO> bookings = bookingService.getBookingByTenantId(tenant1.getUserId());
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


        return null;
    }

}
