package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.dto.PropertyRequest;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface PropertyService {

    static PropertyDTO buildPropertyDTO(Property property) {
        return new PropertyDTO(
                property.getId(),
                property.getPropertyType(),
                property.getPropertyDescription(),
                property.getAmenities(),
                property.getAvailabilityStatus(),
                property.getPropertyPhotos(),
                property.getAddress(),
                UserService.buildUserBasicInfoFromUserEntity(property.getOwner()));
    }

    void addProperty(PropertyRequest propertyDTO, List<MultipartFile> propertyPhotos);

    PropertyDTO getProperty(Long id);

    Property updateProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getPropertiesByStatus(PropertyStatus propertyStatus);

    void deleteProperty(Long id);

}
