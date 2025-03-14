package group3_real_estate_rental_system.Booking;

import java.util.List;

public interface BookingService {
    void addBooking(Long tenantId, Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    void deleteBooking(Long id);
    List<Booking> getBookingByTenantId(Long tenantId);
    void approveBooking(Long bookingId, Long propertyOwnerId);

}
