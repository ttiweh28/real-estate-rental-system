package group3_real_estate_rental_system.User.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tenant extends User {

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Booking> bookings = new ArrayList<>();

    public List<Lease> getLeases() {
        return leases;
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public void addLease(Lease lease) {
        this.leases.add(lease);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking) {

        this.bookings.add(booking);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "leases=" + leases +
                ", bookings=" + bookings +
                '}';
    }
}
