package cs425group3_real_estate_rental_system.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Embeddable
@RequiredArgsConstructor
public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;

    protected Address() {
        this.street = null;
        this.city = null;
        this.state = null;
        this.zipCode = null;
        this.country = null;
    }
}