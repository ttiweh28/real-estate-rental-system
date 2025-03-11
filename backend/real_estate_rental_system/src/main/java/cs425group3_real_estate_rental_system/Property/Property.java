package cs425group3_real_estate_rental_system.Property;

import cs425group3_real_estate_rental_system.Lease.Lease;
import cs425group3_real_estate_rental_system.User.entity.PropertyOwner;
import cs425group3_real_estate_rental_system.common.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Property {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    private String propertyType;
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
