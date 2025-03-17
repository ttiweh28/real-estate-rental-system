package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.Booking.dto.BookingDTO;
import group3_real_estate_rental_system.Booking.dto.BookingRequest;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.Property.PropertyService;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserService;

import java.util.List;

public interface BookingService {
    static BookingDTO buildBookingTDO(Booking booking) {
        return booking != null ? new BookingDTO(booking.getId(),
                booking.getBookingDate(),
                booking.getBookingStatus(),
                UserService.buildUserBasicInfoFromUserEntity(booking.getApprovedBy()),
                UserService.buildUserBasicInfoFromUserEntity(booking.getTenant()),
                PropertyService.buildPropertyDTO(new Property())) : null;
    }

    void addBooking(BookingRequest booking);

    List<BookingDTO> getBookings();

    BookingDTO getBookingById(Long id);

    void deleteBooking(Long id);

    List<BookingDTO> getBookingByTenantId(Long tenantId);

    void approveBooking(Long bookingId, Long propertyOwnerId);
}
