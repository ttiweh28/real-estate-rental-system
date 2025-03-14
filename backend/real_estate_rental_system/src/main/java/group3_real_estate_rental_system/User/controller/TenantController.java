package group3_real_estate_rental_system.User.controller;

import group3_real_estate_rental_system.Booking.Booking;
import group3_real_estate_rental_system.Booking.BookingServiceImpl;
import group3_real_estate_rental_system.Lease.Lease;
import group3_real_estate_rental_system.User.entity.Tenant;
import group3_real_estate_rental_system.User.service.impl.TenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired
    private TenantServiceImpl tenantServiceImpl;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;


    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Tenant tenant = tenantServiceImpl.getTenantById(id);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantServiceImpl.getAllTenants();
        return ResponseEntity.ok(tenants);
    }
    @PostMapping("/{tenantId}/bookings")
    public ResponseEntity<Booking> addBooking(@PathVariable Long tenantId,@RequestBody Booking booking) {
        bookingServiceImpl.addBooking(tenantId,booking);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{tenantId}/bookings")
    public ResponseEntity<List<Booking>> getBookings(@PathVariable Long tenantId) {
       List<Booking> tenantBookings = bookingServiceImpl.getBookingByTenantId(tenantId);
        return new ResponseEntity<>(tenantBookings, HttpStatus.OK);
    }
    @PutMapping("/{tenantId}/sign-lease/{leaseId}")
    public ResponseEntity<Lease> signLease(@PathVariable Long tenantId, @PathVariable Long leaseId, @RequestParam Boolean signed) {
        Lease updatedLease = tenantServiceImpl.signLease(tenantId, leaseId,signed);
        return ResponseEntity.ok(updatedLease);
    }
}
