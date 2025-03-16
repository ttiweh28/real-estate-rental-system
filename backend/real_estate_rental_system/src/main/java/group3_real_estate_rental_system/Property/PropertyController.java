package group3_real_estate_rental_system.Property;

import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.dto.PropertyRequest;
import group3_real_estate_rental_system.Property.dto.PropertyResponse;
import group3_real_estate_rental_system.common.BaseResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<PropertyResponse> getProperties(  @RequestParam(required = false) PropertyStatus status) {
        List<PropertyDTO> properties = propertyService.getPropertiesByStatus(status);
        PropertyResponse propertyResponse = BaseResponse.successResponse(PropertyResponse.class);
        propertyResponse.setProperties(properties);

        return ResponseEntity.ok(propertyResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> getBookingById(@PathVariable Long id) {
        PropertyDTO property = propertyService.getProperty(id);
        PropertyResponse propertyResponse = BaseResponse.successResponse(PropertyResponse.class);
        propertyResponse.setProperties(List.of(property));

        return ResponseEntity.ok(propertyResponse);
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProperties(
            @Valid @NotNull @ModelAttribute("property") PropertyRequest property,
            @RequestParam(value = "propertyPhotos", required = false) List<MultipartFile> propertyPhotos) {
        propertyService.addProperty(property, propertyPhotos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBooking(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }

}
