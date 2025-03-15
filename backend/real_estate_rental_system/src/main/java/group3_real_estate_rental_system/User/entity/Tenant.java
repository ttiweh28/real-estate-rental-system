package group3_real_estate_rental_system.User.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

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
    private List<Booking> bookings= new ArrayList<>();

    public List<Lease> getLeases() {
        return leases;
    }

    public void addLease(Lease lease) {
        this.leases.add(lease);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {

        this.bookings.add(booking);
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "leases=" + leases +
                ", bookings=" + bookings +
                '}';
    }
}
