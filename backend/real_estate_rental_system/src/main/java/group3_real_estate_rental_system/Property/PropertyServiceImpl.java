package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.dto.PropertyRequest;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserService;
import group3_real_estate_rental_system.User.entity.User;
import group3_real_estate_rental_system.common.Address;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import group3_real_estate_rental_system.imageUpload.ImageUploadService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;
    private ImageUploadService imageUploadService;
    private UserService userService;

    public PropertyServiceImpl(PropertyRepository propertyRepository, ImageUploadService imageUploadService, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.imageUploadService = imageUploadService;
        this.userService = userService;
    }

    @Override
    public void addProperty(PropertyRequest propertyRequest, List<MultipartFile> propertyPhotos) {

        Property property = new Property();
        property.setPropertyDescription(propertyRequest.getDescription());
        property.setPropertyType(propertyRequest.getType());
        property.setAmenities(propertyRequest.getAmenities());
        property.setAvailabilityStatus(propertyRequest.getAvailabilityStatus());

        Address address = new Address(propertyRequest.getStreet(), propertyRequest.getCity(), propertyRequest.getState(), propertyRequest.getZipCode(), propertyRequest.getCountry());
        property.setAddress(address);


        if (propertyPhotos != null && propertyPhotos.size() > 0) {
            List<String> photos = imageUploadService.uploadImages(propertyPhotos);
            property.setPropertyPhotos(photos);
        }

        User user = new User();
        user.setId(3L);
        property.setOwner(user);
        propertyRepository.save(property);

    }

    @Override
    public PropertyDTO getProperty(Long id) {

        Property property = propertyRepository.getPropertiesById(id);
        if (property != null) {
            return PropertyService.buildPropertyDTO(property);
        }
        return null;
    }

    @Override
    public Property updateProperty(PropertyDTO propertyDTO) {
        return null;
    }

    @Override
    public List<PropertyDTO> getPropertiesByStatus(PropertyStatus propertyStatus) {

        Sort sort = Sort.by(Sort.Order.desc("createdAt"));
        List<Property> properties;
        if (propertyStatus != null) {
            properties = propertyRepository.findAllByAvailabilityStatus(propertyStatus, sort);
        }else {
            properties = propertyRepository.findAll(sort);
        }

        if (properties == null || properties.isEmpty()) {
            return new ArrayList<>();
        }
        return properties.stream().map( pro -> PropertyService.buildPropertyDTO(pro)).collect(Collectors.toList())  ;
    }

    @Override
    public void deleteProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            propertyRepository.delete(property);
        } else {
            throw new ResourceNotFoundException("Property with id " + id + " not found");
        }
    }
}
