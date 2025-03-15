package group3_real_estate_rental_system.User.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@NoArgsConstructor
@Entity
public class Tenant extends User {

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Booking> bookings;

    public List<Lease> getLeases() {
        return leases;
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public List<Booking> getBookings() {
        return bookings;
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
