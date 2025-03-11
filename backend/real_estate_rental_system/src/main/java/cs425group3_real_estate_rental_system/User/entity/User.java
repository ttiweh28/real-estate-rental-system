package cs425group3_real_estate_rental_system.User.entity;

import cs425group3_real_estate_rental_system.common.Address;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @Embedded
    private Address address;

}
