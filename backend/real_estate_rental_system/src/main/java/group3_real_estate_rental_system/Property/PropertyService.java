package group3_real_estate_rental_system.Property;

import java.util.Date;
import java.util.List;

public interface PropertyService {

    Property getProperty(Long id);

    List<Property> getPropertiesOrderByDate(Date date, int limit, int page);

}
