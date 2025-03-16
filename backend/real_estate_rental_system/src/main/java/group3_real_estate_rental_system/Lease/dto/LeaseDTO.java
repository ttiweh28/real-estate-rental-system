package group3_real_estate_rental_system.Lease.dto;

import group3_real_estate_rental_system.Lease.LeaseStatus;
import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.User.dto.UserDTO;

import java.time.LocalDateTime;

public class LeaseDTO {

    private String leaseURL;
    private LocalDateTime tenantSignedDate;
    private LocalDateTime propertyOwnerSignedDate;
    private LocalDateTime expiryDate;
    private LeaseStatus leaseStatus;
    private Boolean signed;
    private PropertyDTO property;
    private UserBasicInfo tenant;
    private UserBasicInfo propertyOwner;
}
