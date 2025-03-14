package group3_real_estate_rental_system.User.service;

import group3_real_estate_rental_system.User.entity.Tenant;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TenantService {

    Tenant getTenantById(Long id);
    List<Tenant> getAllTenants();
}
