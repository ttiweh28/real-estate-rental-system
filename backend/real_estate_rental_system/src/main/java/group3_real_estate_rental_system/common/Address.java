package group3_real_estate_rental_system.common;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(

        String street,
        String city,
        String state,
        String zipCode,
        String country
) {
    public Address() {
        this("", "", "", "", "");  // Default empty values
    }
}



