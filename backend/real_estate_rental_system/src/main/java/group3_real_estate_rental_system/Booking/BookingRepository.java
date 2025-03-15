package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.User.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> getBookingByTenant(Tenant tenant);
}
