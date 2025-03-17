package group3_real_estate_rental_system.Property.dto;

import group3_real_estate_rental_system.Property.PropertyStatus;
import group3_real_estate_rental_system.common.Address;
import group3_real_estate_rental_system.common.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PropertyRequest extends BaseRequest {
    private String type;
    private String description;
    private List<String> amenities;
//    @NotNull(message = "Status cannot be null")
//    @NotBlank(message = "Status cannot be blank")
    private PropertyStatus availabilityStatus;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private Long ownerId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public PropertyStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(PropertyStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
