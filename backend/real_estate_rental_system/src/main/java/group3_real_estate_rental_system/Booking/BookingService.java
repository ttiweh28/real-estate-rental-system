package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.Booking.dto.BookingDTO;
import group3_real_estate_rental_system.Booking.dto.BookingRequest;
import group3_real_estate_rental_system.Booking.entity.Booking;

import java.util.List;

public interface BookingService {
    void addBooking(BookingRequest booking);

    List<BookingDTO> getBookings();

    Booking getBookingById(Long id);

    void deleteBooking(Long id);

    List<BookingDTO> getBookingByTenantId(Long tenantId);

    void approveBooking(Long bookingId, Long propertyOwnerId);

}
