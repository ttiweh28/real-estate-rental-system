package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.repository.PropertyOwnerRepository;
import group3_real_estate_rental_system.User.repository.TenantRepository;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public void addBooking(Long tenantId, Booking booking) {
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(()-> new ResourceNotFoundException("Tenant not found"));
        booking.setTenant(tenant);
        booking.setBookingDate(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            return booking;
        }else {
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
        }else{
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    public List<Booking> getBookingByTenantId(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).orElse(null);
        if (tenant != null) {
            return tenant.getBookings();
        }else {
            throw new ResourceNotFoundException("Tenant with id " + tenantId + " not found");
        }
    }

    @Override
    public void approveBooking(Long bookingId, Long propertyOwnerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
        PropertyOwner propertyOwner = propertyOwnerRepository.findById(propertyOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("PropertyOwner not found with id " + propertyOwnerId));

        booking.setApprovedBy(propertyOwner);
        booking.setBookingStatus(BookingStatus.APPROVED);
        bookingRepository.save(booking);
    }
}
