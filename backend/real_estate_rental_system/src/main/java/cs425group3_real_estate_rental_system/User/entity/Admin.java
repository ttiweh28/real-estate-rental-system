package cs425group3_real_estate_rental_system.User.entity;

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
public class Admin extends User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

}
