package group3_real_estate_rental_system.User.service.impl;

import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.Lease.LeaseRepository;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.repository.TenantRepository;
import group3_real_estate_rental_system.User.service.TenantService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private LeaseRepository leaseRepository;


    @Override
    public Tenant getTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id).orElse(null);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant with ID " +id+" not found");
        }
        return tenant ;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    @Transactional
    public Lease signLease(Long tenantId, Long leaseId) {

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new IllegalArgumentException("Tenant not found"));


        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() -> new IllegalArgumentException("Lease not found"));

        if (lease.getTenantSignedDate() != null) {
            throw new IllegalStateException("Lease has already been signed by the tenant.");
        }

        if (lease.getTenant() == null) {
            lease.setTenant(tenant);
        } else if (!lease.getTenant().equals(tenant)) {
            throw new IllegalStateException("This lease belongs to another tenant.");
        }


        lease.setTenantSignedDate(LocalDateTime.now());

        return leaseRepository.save(lease);
    }

}
