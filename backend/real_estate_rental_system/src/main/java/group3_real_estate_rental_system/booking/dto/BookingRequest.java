package group3_real_estate_rental_system.booking.dto;

import group3_real_estate_rental_system.booking.BookingStatus;
import group3_real_estate_rental_system.common.BaseRequest;

import java.time.LocalDateTime;

public class BookingRequest extends BaseRequest {

    private LocalDateTime bookingDate;

    private BookingStatus bookingStatus;

    private Long tenantId;

    private Long propertyId;


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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
