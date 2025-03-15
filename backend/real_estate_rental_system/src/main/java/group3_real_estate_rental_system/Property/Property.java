package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.common.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Property {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    private String propertyType;

    private String propertyDescription;

    @ElementCollection
    @CollectionTable(name = "property_amenities", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenity")
    private List<String> amenities;

    private PropertyStatus availabilityStatus;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Lease> leases;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PropertyOwner owner;

    public Long getPropertyId() {
        return propertyId;
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

    public PropertyOwner getOwner() {
        return owner;
    }

    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
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
