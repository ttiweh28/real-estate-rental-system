package group3_real_estate_rental_system.Lease;

import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.entity.User;
import group3_real_estate_rental_system.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Lease extends BaseEntity {

    private String leaseURL;
    private LocalDateTime tenantSignedDate;
    private LocalDateTime propertyOwnerSignedDate;
    private LocalDateTime expiryDate;
    private LeaseStatus leaseStatus;
    private Boolean signed;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User propertyOwner;


    public String getLeaseURL() {
        return leaseURL;
    }

    public void setLeaseURL(String leaseURL) {
        this.leaseURL = leaseURL;
    }

    public LocalDateTime getTenantSignedDate() {
        return tenantSignedDate;
    }

    public void setTenantSignedDate(LocalDateTime tenantSignedDate) {
        this.tenantSignedDate = tenantSignedDate;
    }

    public LocalDateTime getPropertyOwnerSignedDate() {
        return propertyOwnerSignedDate;
    }

    public void setPropertyOwnerSignedDate(LocalDateTime propertyOwnerSignedDate) {
        this.propertyOwnerSignedDate = propertyOwnerSignedDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LeaseStatus getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(LeaseStatus leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public User getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(User propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "LeaseId=" + getId() +
                ", leaseURL='" + leaseURL + '\'' +
                ", tenantSignedDate=" + tenantSignedDate +
                ", propertyOwnerSignedDate=" + propertyOwnerSignedDate +
                ", expiryDate=" + expiryDate +
                ", leaseStatus=" + leaseStatus +
                ", signed=" + signed +
                ", property=" + property +
                ", tenant=" + tenant +
                ", propertyOwner=" + propertyOwner +
                '}';
    }
}
