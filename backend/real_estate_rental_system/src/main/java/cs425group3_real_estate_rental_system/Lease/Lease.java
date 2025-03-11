package cs425group3_real_estate_rental_system.Lease;

import cs425group3_real_estate_rental_system.Property.Property;
import cs425group3_real_estate_rental_system.User.entity.PropertyOwner;
import cs425group3_real_estate_rental_system.User.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Lease {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LeaseId;
    private String leaseURL;
    private LocalDateTime tenantSignedDate;
    private LocalDateTime propertyOwnerSignedDate;
    private LocalDateTime expiryDate;
    private LeaseStatus leaseStatus;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PropertyOwner propertyOwner;

}
