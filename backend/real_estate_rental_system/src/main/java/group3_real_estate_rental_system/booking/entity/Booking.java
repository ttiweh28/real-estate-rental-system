package group3_real_estate_rental_system.booking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group3_real_estate_rental_system.booking.BookingStatus;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.entity.User;
import group3_real_estate_rental_system.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking extends BaseEntity {

    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "approved_by_propertyOwner_id")
    private User approvedBy;

    @ManyToOne
    @JsonBackReference
    private User tenant;

    @OneToOne
    private Property property;

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

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + getId() +
                ", bookingDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                ", approvedBy=" + approvedBy +
                //", tenant=" + tenant.getUserId() +
                '}';
    }
}
