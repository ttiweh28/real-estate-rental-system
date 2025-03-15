package group3_real_estate_rental_system.User.entity;

import group3_real_estate_rental_system.common.Address;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity

@ToString
@EqualsAndHashCode
public class Admin extends User {

    public Admin(String firstName, String lastName, String userName, String password, Address address) {
        super(firstName, lastName, userName, password, address);  // Calls User constructor
    }

    public Admin() {

    }


}
