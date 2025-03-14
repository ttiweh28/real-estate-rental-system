package group3_real_estate_rental_system.User.service.impl;

import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.repository.TenantRepository;
import group3_real_estate_rental_system.User.service.TenantService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantRepository tenantRepository;


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
}
