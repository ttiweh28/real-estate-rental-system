package group3_real_estate_rental_system.Property.dto;

import group3_real_estate_rental_system.common.BaseResponse;

import java.util.List;

public class PropertyResponse extends BaseResponse {
    private List<PropertyDTO> properties;

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }
}
