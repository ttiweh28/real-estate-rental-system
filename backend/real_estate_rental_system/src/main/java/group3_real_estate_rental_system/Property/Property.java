package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.common.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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


}
