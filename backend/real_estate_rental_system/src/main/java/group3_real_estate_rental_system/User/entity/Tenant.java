package group3_real_estate_rental_system.User.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Tenant extends User {

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "Tenant{" +
                "leases=" + leases +
               // ", bookings=" + bookings +
                '}';
    }
}
