package cs425group3_real_estate_rental_system.User.entity;

import cs425group3_real_estate_rental_system.Booking.Booking;
import cs425group3_real_estate_rental_system.Lease.Lease;
import cs425group3_real_estate_rental_system.Property.Property;
import cs425group3_real_estate_rental_system.User.entity.User;
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
public class PropertyOwner extends User {

    private Long propertyOwnerId;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties;
    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> Bookings;

}
