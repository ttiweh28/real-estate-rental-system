package group3_real_estate_rental_system.Property;


import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


import group3_real_estate_rental_system.Property.dto.PropertyDTO;
import group3_real_estate_rental_system.Property.dto.PropertyRequest;
import group3_real_estate_rental_system.Property.entity.Property;
import group3_real_estate_rental_system.User.UserService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import group3_real_estate_rental_system.imageUpload.ImageUploadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest {

        @Mock
        private PropertyRepository propertyRepository;

        @Mock
        private ImageUploadService imageUploadService;

        @Mock
        private UserService userService;

        @InjectMocks
        private PropertyServiceImpl propertyService;

        @BeforeEach
        void setUp() {
            propertyService = new PropertyServiceImpl(propertyRepository, imageUploadService, userService);
        }

        @Test
        void testAddProperty() {

            PropertyRequest request = new PropertyRequest();
            request.setDescription("Beautiful apartment");
            request.setType("Apartment");
            request.setAmenities(Arrays.asList("Pool", "Gym"));
            request.setAvailabilityStatus(PropertyStatus.AVAILABLE);
            request.setStreet("123 Main St");
            request.setCity("New York");
            request.setState("NY");
            request.setZipCode("10001");
            request.setCountry("USA");

            List<MultipartFile> photos = new ArrayList<>();
            List<String> uploadedPhotos = Arrays.asList("photo1.jpg", "photo2.jpg");


            propertyService.addProperty(request, photos);


            verify(propertyRepository).save(any(Property.class)); // Removed times(1), as it's redundant
        }

        @Test
        void testGetPropertyExists() {

            Property property = new Property();
            property.setId(1L);
            property.setPropertyDescription("Nice house");

            when(propertyRepository.getPropertiesById(1L)).thenReturn(property);


            PropertyDTO result = propertyService.getProperty(1L);


            assertNotNull(result);
            assertEquals("Nice house", result.getPropertyDescription());
        }

        @Test
        void testGetPropertyNotFound() {

            when(propertyRepository.getPropertiesById(1L)).thenReturn(null);


            PropertyDTO result = propertyService.getProperty(1L);


            assertNull(result);
        }

        @Test
        void testDeletePropertyExists() {
            Property property = new Property();
            property.setId(1L);

            when(propertyRepository.findById(1L)).thenReturn(Optional.of(property));

            propertyService.deleteProperty(1L);

            verify(propertyRepository).delete(property);
        }

        @Test
        void testDeletePropertyNotFound() {

            when(propertyRepository.findById(1L)).thenReturn(Optional.empty());

            Exception exception = assertThrows(ResourceNotFoundException.class, () -> propertyService.deleteProperty(1L));

            assertEquals("Property with id 1 not found", exception.getMessage());
        }
    }

