package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.Booking.dto.BookingDTO;
import group3_real_estate_rental_system.Booking.dto.BookingRequest;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.Property.PropertyService;
import group3_real_estate_rental_system.User.UserService;
import group3_real_estate_rental_system.User.dto.UserDTO;
import group3_real_estate_rental_system.User.entity.User;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    UserService userService;
    private final PropertyService propertyService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, PropertyService propertyService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @Override
    public void addBooking(BookingRequest bookingRequest) {
        UserDTO tenant = userService.getUserById(bookingRequest.getTenantId());
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant not found");
        }
        Property property = propertyService.getProperty(bookingRequest.getPropertyId());
        if (property == null) {
            throw new ResourceNotFoundException("Property not found");
        }
        //FIX it - find a way instead of doing this
        User user = new User();
        user.setId(tenant.getUserId());

        Booking booking = new Booking();
        booking.setTenant(user);
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setProperty(property);
        bookingRepository.save(booking);
    }


    //TODO fix it for admin tenant and propertyOwner
    @Override
    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(booking ->  BookingService.buildBookingTDO(booking)).collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            return BookingService.buildBookingTDO(booking);
        } else {
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
        } else {
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
    }

    @Override
    public List<BookingDTO> getBookingByTenantId(Long tenantId) {
        UserDTO tenant = userService.getUserById(tenantId);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant with id " + tenantId + " not found");
        }
        List<Booking> bookingByTenant = bookingRepository.getBookingByTenantId(tenant.getUserId());

        return bookingByTenant.stream().map(booking ->  BookingService.buildBookingTDO(booking)).toList();
    }



    //TODO  fix it to work for booking cancellation

    @Override
    public void approveBooking(Long bookingId, Long propertyOwnerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));

        UserDTO propertyOwner = userService.getUserById(propertyOwnerId);

        if (propertyOwner == null) {
            throw new ResourceNotFoundException("Property owner not found with id " + propertyOwnerId);
        }

        User user = new User();
        user.setId(propertyOwner.getUserId());

        booking.setApprovedBy(user);
        booking.setBookingStatus(BookingStatus.APPROVED);

        bookingRepository.save(booking);
    }
}
