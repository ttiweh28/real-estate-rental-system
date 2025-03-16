package group3_real_estate_rental_system.Lease;


import group3_real_estate_rental_system.Property.PropertyRepository;
import group3_real_estate_rental_system.User.UserService;
import group3_real_estate_rental_system.User.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseService {
    private final LeaseRepository leaseRepository;
    private final UserService userService;
    private final PropertyRepository propertyRepository;

    public LeaseService(LeaseRepository leaseRepository, UserService userService, PropertyRepository propertyRepository) {
        this.leaseRepository = leaseRepository;
        this.userService = userService;
        this.propertyRepository = propertyRepository;
    }

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    public Optional<Lease> getLeaseById(Long id) {
        return leaseRepository.findById(id);
    }

    public Lease createLease(Lease lease) {
        return leaseRepository.save(lease);
    }

    public Lease updateLease(Long id, Lease leaseDetails) {
        return leaseRepository.findById(id).map(lease -> {
            lease.setTenant(leaseDetails.getTenant());
            lease.setPropertyOwner(leaseDetails.getPropertyOwner());
            lease.setProperty(leaseDetails.getProperty());
            lease.setTenantSignedDate(leaseDetails.getTenantSignedDate());
            lease.setPropertyOwnerSignedDate(leaseDetails.getPropertyOwnerSignedDate());
            lease.setExpiryDate(leaseDetails.getExpiryDate());
            lease.setLeaseURL(leaseDetails.getLeaseURL());
            return leaseRepository.save(lease);
        }).orElseThrow(() -> new RuntimeException("Lease not found"));
    }

    public void deleteLease(Long id) {
        leaseRepository.deleteById(id);
    }
}
