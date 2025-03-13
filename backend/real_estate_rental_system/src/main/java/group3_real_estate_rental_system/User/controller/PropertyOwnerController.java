package group3_real_estate_rental_system.User.controller;


import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.service.PropertyOwnerService;
import group3_real_estate_rental_system.User.service.impl.PropertyOwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/property-owners")
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerServiceImpl propertyOwnerServiceImpl;

    @GetMapping
    public ResponseEntity<List<PropertyOwner>> getPropertyOwners() {
        List<PropertyOwner> owners = propertyOwnerServiceImpl.getAllPropertyOwners();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyOwner> getPropertyOwner(@PathVariable Long id) {
        PropertyOwner propertyOwner = propertyOwnerServiceImpl.getPropertyOwnerById(id);
        return ResponseEntity.ok(propertyOwner);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PropertyOwner>> getPropertyOwnerByFirstName(@RequestParam String firstName) {
        List<PropertyOwner> owners = propertyOwnerServiceImpl.getPropertyOwnerByFirstName(firstName);
        return ResponseEntity.ok(owners);

    }


    @PostMapping
    public ResponseEntity<PropertyOwner> createPropertyOwner(@RequestBody PropertyOwner propertyOwner) {
        PropertyOwner savedOwner = propertyOwnerServiceImpl.savePropertyOwner(propertyOwner);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PropertyOwner> updatePropertyOwner(@RequestBody PropertyOwner propertyOwner, @PathVariable Long id) {
        PropertyOwner savedOwner = propertyOwnerServiceImpl.updatePropertyOwner(id, propertyOwner);
        return ResponseEntity.ok(savedOwner);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PropertyOwner> deletePropertyOwner(@PathVariable Long id) {
        propertyOwnerServiceImpl.deletePropertyOwner(id);
        return ResponseEntity.noContent().build();
    }



}
