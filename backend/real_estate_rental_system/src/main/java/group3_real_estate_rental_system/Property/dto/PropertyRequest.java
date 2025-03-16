package group3_real_estate_rental_system.Property.dto;

import group3_real_estate_rental_system.Property.PropertyStatus;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.common.Address;
import group3_real_estate_rental_system.common.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PropertyRequest extends BaseRequest {
    private String Type;
    private String Description;
    private List<String> amenities;
//    @NotNull(message = "Status cannot be null")
//    @NotBlank(message = "Status cannot be blank")
    private PropertyStatus availabilityStatus;
    private Address address;
    private Long ownerId;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
