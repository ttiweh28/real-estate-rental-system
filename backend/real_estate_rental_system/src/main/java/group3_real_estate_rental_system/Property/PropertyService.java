package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserService;
import group3_real_estate_rental_system.User.dto.UserBasicInfo;

import java.util.Date;
import java.util.List;

public interface PropertyService {

    Property getProperty(Long id);

    List<Property> getPropertiesOrderByDate(Date date, int limit, int page);

    static PropertyDTO buildPropertyDTO(Property property){
        return new PropertyDTO(property.getPropertyType(),
                property.getPropertyDescription(),
                property.getAmenities(),
                property.getAvailabilityStatus(),
                property.getPropertyPhotos(),
                property.getAddress(),
                UserService.buildUserBasicInfoFromUserEntity(property.getOwner()));
    }
}
