package group3_real_estate_rental_system.Property.dto;

import group3_real_estate_rental_system.Property.PropertyStatus;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.common.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PropertyDTO {

    private Long propertyId;
    private String propertyType;
    private String propertyDescription;
    private List<String> amenities;
    @NotNull(message = "Status cannot be null")
    @NotBlank(message = "Status cannot be blank")
    private PropertyStatus availabilityStatus;
    private List<String> propertyPhotos;
    @NotNull(message = "Address cannot be null")
    private Address address;
    private UserBasicInfo owner;

    public PropertyDTO() {}
    public PropertyDTO(Long propertyId, String propertyType, String propertyDescription, List<String> amenities, PropertyStatus availabilityStatus, List<String> propertyPhotos, Address address, UserBasicInfo owner) {
        this.propertyId = propertyId;
        this.propertyType = propertyType;
        this.propertyDescription = propertyDescription;
        this.amenities = amenities;
        this.availabilityStatus = availabilityStatus;
        this.propertyPhotos = propertyPhotos;
        this.address = address;
        this.owner = owner;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
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

    public List<String> getPropertyPhotos() {
        return propertyPhotos;
    }

    public void setPropertyPhotos(List<String> propertyPhotos) {
        this.propertyPhotos = propertyPhotos;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserBasicInfo getOwner() {
        return owner;
    }

    public void setOwner(UserBasicInfo owner) {
        this.owner = owner;
    }
}
