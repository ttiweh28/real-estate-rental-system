package group3_real_estate_rental_system.User.service;

import group3_real_estate_rental_system.User.entity.PropertyOwner;

import java.util.List;

public interface PropertyOwnerService {

    PropertyOwner savePropertyOwner(PropertyOwner propertyOwner);

    List<PropertyOwner> getAllPropertyOwners();

    PropertyOwner getPropertyOwnerById(Long id);

    List<PropertyOwner> getPropertyOwnerByFirstName(String firstName);

    PropertyOwner updatePropertyOwner(Long id, PropertyOwner propertyOwner);

    void deletePropertyOwner(Long id);
}
