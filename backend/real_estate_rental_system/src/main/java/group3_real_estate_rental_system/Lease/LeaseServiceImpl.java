package group3_real_estate_rental_system.Lease;

import group3_real_estate_rental_system.Lease.dto.LeaseDTO;
import group3_real_estate_rental_system.Lease.dto.LeaseRequest;
//import group3_real_estate_rental_system.Lease;
import group3_real_estate_rental_system.Property.PropertyRepository;
import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserRepository;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter

@Service
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public LeaseServiceImpl(LeaseRepository leaseRepository, PropertyRepository propertyRepository, UserRepository userRepository) {
        this.leaseRepository = leaseRepository;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createLease(LeaseRequest leaseRequest) {
        Optional<Property> propertyOpt = propertyRepository.findById(leaseRequest.getPropertyId());
        Optional<User> tenantOpt = userRepository.findById(leaseRequest.getTenantId());
        Optional<User> ownerOpt = userRepository.findById(leaseRequest.getPropertyOwnerId());

        if (propertyOpt.isEmpty() || tenantOpt.isEmpty() || ownerOpt.isEmpty()) {
            throw new RuntimeException("Property or users not found");
        }

        Lease lease = new Lease();
        lease.setLeaseURL(leaseRequest.getLeaseURL());
        lease.setExpiryDate(leaseRequest.getExpiryDate());
        lease.setLeaseStatus(leaseRequest.getLeaseStatus());
        lease.setSigned(leaseRequest.getSigned());
        lease.setProperty(propertyOpt.get());
        lease.setTenant(tenantOpt.get());
        lease.setPropertyOwner(ownerOpt.get());

        leaseRepository.save(lease);
    }

    @Override
    public List<LeaseDTO> getAllLeases() {
        List<Lease> leases = leaseRepository.findAll();
        return leases.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaseDTO getLeaseById(Long id) {
        Optional<Lease> lease = leaseRepository.findById(id);
        return lease.map(this::convertToDTO).orElseThrow(() -> new RuntimeException("Lease not found"));
    }

    @Override
    public void updateLease(Long id, LeaseDTO leaseDTO) {
        Optional<Lease> existingLease = leaseRepository.findById(id);
        if (existingLease.isPresent()) {
            Lease lease = existingLease.get();
            lease.setLeaseURL(leaseDTO.getLeaseURL());
            lease.setExpiryDate(leaseDTO.getExpiryDate());
            lease.setLeaseStatus(leaseDTO.getLeaseStatus());
            lease.setSigned(leaseDTO.getSigned());

            // Update dates if provided
            if (leaseDTO.getTenantSignedDate() != null) {
                lease.setTenantSignedDate(leaseDTO.getTenantSignedDate());
            }

            if (leaseDTO.getPropertyOwnerSignedDate() != null) {
                lease.setPropertyOwnerSignedDate(leaseDTO.getPropertyOwnerSignedDate());
            }

            leaseRepository.save(lease);
        } else {
            throw new RuntimeException("Lease not found");
        }
    }

    @Override
    public void deleteLease(Long id) {
        if (!leaseRepository.existsById(id)) {
            throw new RuntimeException("Lease not found");
        }
        leaseRepository.deleteById(id);
    }

    private LeaseDTO convertToDTO(Lease lease) {
        PropertyDTO propertyDTO;
        propertyDTO = new PropertyDTO();
        propertyDTO.setId(lease.getProperty().getId());
        // Set other property fields as needed...

        // Create UserBasicInfo objects using the constructor with first name, last name and photo
        UserBasicInfo tenant = new UserBasicInfo(
                lease.getTenant().getFirstName(),
                lease.getTenant().getLastName(),
                lease.getTenant().getPhoto()
        );

        UserBasicInfo owner = new UserBasicInfo(
                lease.getPropertyOwner().getFirstName(),
                lease.getPropertyOwner().getLastName(),
                lease.getPropertyOwner().getPhoto()
        );

        return new LeaseDTO(
                lease.getId(),
                lease.getLeaseURL(),
                lease.getTenantSignedDate(),
                lease.getPropertyOwnerSignedDate(),
                lease.getExpiryDate(),
                lease.getLeaseStatus(),
                lease.getSigned(),
                propertyDTO,
                tenant,
                owner
        );
    }
}