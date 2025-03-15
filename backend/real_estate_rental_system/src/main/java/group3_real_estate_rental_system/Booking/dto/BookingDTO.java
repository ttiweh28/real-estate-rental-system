package group3_real_estate_rental_system.Booking.dto;

import group3_real_estate_rental_system.Booking.BookingStatus;
import group3_real_estate_rental_system.Property.Property;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;

import java.time.LocalDateTime;

public class BookingDTO {

    private final Long bookingId;

    private final LocalDateTime bookingDate;

    private final BookingStatus bookingStatus;

    private final PropertyOwner approvedBy;

    private final Tenant tenant;

    private final Property property;

    public BookingDTO(Long bookingId, LocalDateTime bookingDate, BookingStatus bookingStatus, PropertyOwner approvedBy, Tenant tenant, Property property) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.approvedBy = approvedBy;
        this.tenant = tenant;
        this.property = property;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public PropertyOwner getApprovedBy() {
        return approvedBy;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public Property getProperty() {
        return property;
    }
}
