package group3_real_estate_rental_system.Lease.dto;

import group3_real_estate_rental_system.Lease.LeaseStatus;
import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class LeaseDTO {

    //private Long Id;
    private String leaseURL;
    private LocalDateTime tenantSignedDate;
    private LocalDateTime propertyOwnerSignedDate;
    private LocalDateTime expiryDate;
    private LeaseStatus leaseStatus;
    private Boolean signed;
    private PropertyDTO property;
    private UserBasicInfo tenant;
    private UserBasicInfo propertyOwner;

    public LeaseDTO(Long id, String leaseURL, LocalDateTime tenantSignedDate, LocalDateTime propertyOwnerSignedDate, LocalDateTime expiryDate, LeaseStatus leaseStatus, Boolean signed, PropertyDTO propertyDTO, UserBasicInfo tenant, UserBasicInfo owner) {

    }

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

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }

    public UserBasicInfo getTenant() {
        return tenant;
    }

    public void setTenant(UserBasicInfo tenant) {
        this.tenant = tenant;
    }

    public UserBasicInfo getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(UserBasicInfo propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    //    public LeaseDTO() {
//    }
}
