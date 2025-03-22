package group3_real_estate_rental_system.Lease;

import group3_real_estate_rental_system.Lease.dto.LeaseDTO;
import group3_real_estate_rental_system.Lease.dto.LeaseRequest;

import java.util.List;

public interface LeaseService {

    void createLease(LeaseRequest leaseRequest);

    List<LeaseDTO> getAllLeases();

    LeaseDTO getLeaseById(Long id);

    void updateLease(Long id, LeaseDTO leaseDTO);

    void deleteLease(Long id);
}
