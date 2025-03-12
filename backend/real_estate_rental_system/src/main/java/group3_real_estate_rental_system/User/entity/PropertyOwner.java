package group3_real_estate_rental_system.User.entity;

import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.Property.Property;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PropertyOwner extends User {

    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> Bookings;

}
