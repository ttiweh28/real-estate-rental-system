package group3_real_estate_rental_system.Booking;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
