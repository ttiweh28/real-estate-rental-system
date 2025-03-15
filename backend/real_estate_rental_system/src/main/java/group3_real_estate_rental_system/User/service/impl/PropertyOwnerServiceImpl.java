package group3_real_estate_rental_system.User.service.impl;

import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.repository.PropertyOwnerRepository;
import group3_real_estate_rental_system.User.service.PropertyOwnerService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyOwnerServiceImpl implements PropertyOwnerService {

    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public PropertyOwner savePropertyOwner(PropertyOwner propertyOwner) {
        return propertyOwnerRepository.save(propertyOwner);
    }

    @Override
    public List<PropertyOwner> getAllPropertyOwners() {
        return propertyOwnerRepository.findAll();
    }

    @Override
    public PropertyOwner getPropertyOwnerById(Long id) {
        Optional<PropertyOwner> propertyOwner = propertyOwnerRepository.findById(id);

        if (propertyOwner.isPresent()) {
            return propertyOwner.get();
        } else {
            throw new ResourceNotFoundException("PropertyOwner not found");
        }
    }


    @Override
    public List<PropertyOwner> getPropertyOwnerByFirstName(String firstName) {
        return propertyOwnerRepository.findByFirstName(firstName);
    }

    @Override
    public PropertyOwner updatePropertyOwner(Long id, PropertyOwner propertyOwnerDetails) {
        Optional<PropertyOwner> optionalOwner = propertyOwnerRepository.findById(id);

        if (optionalOwner.isPresent()) {
            PropertyOwner propertyOwner = optionalOwner.get();

            propertyOwner.setFirstName(propertyOwnerDetails.getFirstName());
            propertyOwner.setLastName(propertyOwnerDetails.getLastName());
            propertyOwner.setUserName(propertyOwnerDetails.getUserName());
            propertyOwner.setPassword(propertyOwnerDetails.getPassword());
            propertyOwner.setAddress(propertyOwnerDetails.getAddress());

            return propertyOwnerRepository.save(propertyOwner);
        } else {
            throw new ResourceNotFoundException("Property Owner not found with ID: " + id);

        }
    }

    @Override
    public void deletePropertyOwner(Long id) {

        Optional<PropertyOwner> optionalOwner = propertyOwnerRepository.findById(id);

        if (optionalOwner.isPresent()) {
            propertyOwnerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Property Owner not found with ID: " + id);
        }
    }
}
