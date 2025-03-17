package group3_real_estate_rental_system.booking.dto;

import group3_real_estate_rental_system.booking.BookingStatus;
import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long bookingId;

    private LocalDateTime bookingDate;

    private BookingStatus bookingStatus;

    private UserBasicInfo approvedBy;

    private UserBasicInfo tenant;

    private PropertyDTO property;

    public BookingDTO(Long bookingId, LocalDateTime bookingDate, BookingStatus bookingStatus, UserBasicInfo approvedBy, UserBasicInfo tenant, PropertyDTO property) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.approvedBy = approvedBy;
        this.tenant = tenant;
        this.property = property;
    }

    public BookingDTO() {
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public UserBasicInfo getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(UserBasicInfo approvedBy) {
        this.approvedBy = approvedBy;
    }

    public UserBasicInfo getTenant() {
        return tenant;
    }

    public void setTenant(UserBasicInfo tenant) {
        this.tenant = tenant;
    }

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }

}
