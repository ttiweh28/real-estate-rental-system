package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.entity.Property;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Override
    public Property getProperty(Long id) {
        return null;
    }

    @Override
    public List<Property> getPropertiesOrderByDate(Date date, int limit, int page) {
        return List.of();
    }
}
