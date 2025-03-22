package group3_real_estate_rental_system.Lease.dto;

import group3_real_estate_rental_system.Lease.LeaseStatus;
import group3_real_estate_rental_system.common.BaseRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LeaseRequest extends BaseRequest {
    private Long tenantId;
    private Long propertyId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long propertyOwnerId;
    private LeaseStatus leaseStatus = LeaseStatus.ACTIVE;
    private Boolean signed = false;
    private String leaseURL;
    @NotNull
    private LocalDateTime expiryDate;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(Long propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
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

    public String getLeaseURL() {
        return leaseURL;
    }

    public void setLeaseURL(String leaseURL) {
        this.leaseURL = leaseURL;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    //    private Double monthlyRent;
//    private String leaseTerms;

}
