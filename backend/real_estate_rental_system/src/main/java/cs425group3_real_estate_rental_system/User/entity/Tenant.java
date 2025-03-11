package cs425group3_real_estate_rental_system.User.entity;

import cs425group3_real_estate_rental_system.Booking.Booking;
import cs425group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tenant extends User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;



}
