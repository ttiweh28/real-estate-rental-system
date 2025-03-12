package group3_real_estate_rental_system.Booking;

import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Booking {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalDateTime bookingDate;

    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "approved_by_propertyowner_id")
    private PropertyOwner approvedBy;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;




}
