package group3_real_estate_rental_system.User.controller;

import group3_real_estate_rental_system.Booking.BookingService;
import group3_real_estate_rental_system.Booking.entity.Booking;
import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    private final BookingService bookingService;

    public TenantController(TenantService tenantService, BookingService bookingService) {
        this.tenantService = tenantService;
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Tenant tenant = tenantService.getTenantById(id);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    /*    @PostMapping("/{tenantId}/bookings")
        public ResponseEntity<Booking> addBooking(@PathVariable Long tenantId,@RequestBody Booking booking) {
            bookingService.addBooking(booking);
           return new ResponseEntity<>(HttpStatus.CREATED);
        }*/
//    @GetMapping("/{tenantId}/bookings")
//    public ResponseEntity<List<Booking>> getBookings(@PathVariable Long tenantId) {
//        List<Booking> tenantBookings = bookingService.getBookingByTenantId(tenantId);
//        return new ResponseEntity<>(tenantBookings, HttpStatus.OK);
//    }

    @PutMapping("/{tenantId}/sign-lease/{leaseId}")
    public ResponseEntity<Lease> signLease(@PathVariable Long tenantId, @PathVariable Long leaseId, @RequestParam Boolean signed) {
        Lease updatedLease = tenantService.signLease(tenantId, leaseId, signed);
        return ResponseEntity.ok(updatedLease);
    }
}
