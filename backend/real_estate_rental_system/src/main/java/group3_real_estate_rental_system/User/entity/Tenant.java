package group3_real_estate_rental_system.User.entity;

import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tenant extends User {

    private Long tenantId;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;



}
