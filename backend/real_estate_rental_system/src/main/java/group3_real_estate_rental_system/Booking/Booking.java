package group3_real_estate_rental_system.Booking;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group3_real_estate_rental_system.Property.Property;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Booking {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "approved_by_propertyowner_id")
    private PropertyOwner approvedBy;

    @ManyToOne
    @JsonBackReference
    private Tenant tenant;

    @OneToOne
    private Property property;

    public Long getBookingId() {
        return bookingId;
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

    public PropertyOwner getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(PropertyOwner approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
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
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                ", approvedBy=" + approvedBy +
                //", tenant=" + tenant.getUserId() +
                '}';
    }
}
