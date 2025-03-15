package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.Booking.dto.BookingDTO;
import group3_real_estate_rental_system.Booking.dto.BookingRequest;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.Property.Property;
import group3_real_estate_rental_system.Property.PropertyService;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.service.PropertyOwnerService;
import group3_real_estate_rental_system.User.service.TenantService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final TenantService tenantService;
    private final PropertyOwnerService propertyOwnerService;
    private final PropertyService propertyService;

    public BookingServiceImpl(BookingRepository bookingRepository, TenantService tenantService, PropertyOwnerService propertyOwnerService, PropertyService propertyService) {
        this.bookingRepository = bookingRepository;
        this.tenantService = tenantService;
        this.propertyOwnerService = propertyOwnerService;
        this.propertyService = propertyService;
    }

    private static List<BookingDTO> buildBookingTester(List<Booking> bookings) {
        return bookings.stream()
                .map(booking -> new BookingDTO(booking.getId(),
                        booking.getBookingDate(),
                        booking.getBookingStatus(),
                        booking.getApprovedBy(),
                        booking.getTenant(),
                        booking.getProperty()))
                .collect(Collectors.toList());
    }

    @Override
    public void addBooking(BookingRequest bookingRequest) {
        Tenant tenant = tenantService.getTenantById(bookingRequest.getTenantId());
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant not found");
        }
        Property property = propertyService.getProperty(bookingRequest.getPropertyId());
        if (property == null) {
            throw new ResourceNotFoundException("Property not found");
        }

        Booking booking = new Booking();
        booking.setTenant(tenant);
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setProperty(property);
        bookingRepository.save(booking);
    }


    //TODO fix it for admin tenant and propertyOwner
    @Override
    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        return buildBookingTester(bookings);
    }

    @Override
    public Booking getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            return booking;
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
        Tenant tenant = tenantService.getTenantById(tenantId);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant with id " + tenantId + " not found");
        }
        List<Booking> bookingByTenant = bookingRepository.getBookingByTenant(tenant);

        return buildBookingTester(bookingByTenant);
    }

    @Override
    public void approveBooking(Long bookingId, Long propertyOwnerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
        PropertyOwner propertyOwner = propertyOwnerService.getPropertyOwnerById(propertyOwnerId);

        if (propertyOwner == null) {
            throw new ResourceNotFoundException("Property owner not found with id " + propertyOwnerId);
        }

        booking.setApprovedBy(propertyOwner);
        booking.setBookingStatus(BookingStatus.APPROVED);
        bookingRepository.save(booking);
    }
}
