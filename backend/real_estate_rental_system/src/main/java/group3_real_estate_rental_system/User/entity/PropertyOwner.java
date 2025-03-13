package group3_real_estate_rental_system.User.entity;

import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.Property.Property;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
public class PropertyOwner extends User {



    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> Bookings;

    public List<Lease> getLeases() {
        return leases;
    }

    public void addLeases(Lease lease) {
        this.leases.add(lease);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperties(Property property) {
        this.properties.add(property);
    }

    public List<Booking> getBookings() {
        return Bookings;
    }

    public void setBookings(Booking booking) {
        this.Bookings.add(booking);
    }
}
