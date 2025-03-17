package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.entity.Property;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findAllByAvailabilityStatus(PropertyStatus availabilityStatus);

    List<Property> findAllByAvailabilityStatus(PropertyStatus availabilityStatus, Sort sort);

    Property getPropertiesById(Long id);
}
