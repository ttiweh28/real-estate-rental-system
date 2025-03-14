package group3_real_estate_rental_system.User.repository;

import group3_real_estate_rental_system.User.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByUserName(String userName);
}
