package group3_real_estate_rental_system.Property.entity;

import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.Property.PropertyStatus;
import group3_real_estate_rental_system.User.entity.User;
import group3_real_estate_rental_system.common.Address;
import group3_real_estate_rental_system.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Property extends BaseEntity {

    private String propertyType;

    private String propertyDescription;

    @ElementCollection
    @CollectionTable(name = "property_amenities", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenity")
    private List<String> amenities;

    private PropertyStatus availabilityStatus;

    @ElementCollection
    @CollectionTable(name = "property_amenities", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenity")
    private List<String> propertyPhotos;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Lease> leases;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<String> getPropertyPhotos() {
        return propertyPhotos;
    }

    public void setPropertyPhotos(List<String> propertyPhotos) {
        this.propertyPhotos = propertyPhotos;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + getId() +
                ", propertyType='" + propertyType + '\'' +
                ", propertyDescription='" + propertyDescription + '\'' +
                ", amenities=" + amenities +
                ", availabilityStatus=" + availabilityStatus +
                ", address=" + address +
                ", leases=" + leases +
                ", owner=" + owner +
                '}';
    }
}
