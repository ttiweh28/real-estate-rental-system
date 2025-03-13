package group3_real_estate_rental_system.User.repository;

import group3_real_estate_rental_system.User.entity.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {

    List<PropertyOwner> findByFirstName(String firstName);
}
