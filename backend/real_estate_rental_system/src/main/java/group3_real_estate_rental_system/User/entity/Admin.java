package group3_real_estate_rental_system.User.entity;

import group3_real_estate_rental_system.Lease.Lease;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Admin extends User {

    private String role;
    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lease> leases;

}
