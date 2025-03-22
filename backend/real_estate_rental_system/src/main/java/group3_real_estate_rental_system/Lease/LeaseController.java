package group3_real_estate_rental_system.Lease;

import group3_real_estate_rental_system.Lease.dto.LeaseDTO;
import group3_real_estate_rental_system.Lease.dto.LeaseRequest;
import group3_real_estate_rental_system.Lease.dto.LeaseResponse;
import group3_real_estate_rental_system.common.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leases")
@PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
public class LeaseController {

    private final LeaseService leaseService;

    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    // ✅ Get all leases (Admin, Tenant, Property Owner)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<LeaseResponse> getAllLeases() {
        List<LeaseDTO> leases = leaseService.getAllLeases();
        LeaseResponse response = BaseResponse.successResponse(LeaseResponse.class);
        response.setLeases(leases);
        return ResponseEntity.ok(response);
    }

    // ✅ Get lease by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<LeaseResponse> getLeaseById(@PathVariable Long id) {
        LeaseDTO lease = leaseService.getLeaseById(id);
        LeaseResponse response = BaseResponse.successResponse(LeaseResponse.class);
        response.setLeases(List.of(lease));
        return ResponseEntity.ok(response);
    }

    // ✅ Create a lease
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<?> createLease(@Valid @RequestBody LeaseRequest leaseRequest) {
        leaseService.createLease(leaseRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // ✅ Update lease
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<?> updateLease(@PathVariable Long id, @RequestBody LeaseDTO lease) {
        leaseService.updateLease(id, lease);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    // ✅ Delete lease
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<?> deleteLease(@PathVariable Long id) {
        leaseService.deleteLease(id);
        return ResponseEntity.noContent().build();
    }
}
