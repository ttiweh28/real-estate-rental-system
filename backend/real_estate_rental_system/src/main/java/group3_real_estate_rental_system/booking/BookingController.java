package group3_real_estate_rental_system.booking;

import group3_real_estate_rental_system.booking.dto.BookingDTO;
import group3_real_estate_rental_system.booking.dto.BookingRequest;
import group3_real_estate_rental_system.booking.dto.BookingResponse;
import group3_real_estate_rental_system.common.BaseResponse;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<BookingResponse> getAllBookings() {
        List<BookingDTO> allBookings = bookingService.getBookings();
        BookingResponse bookingResponse = BaseResponse.successResponse(BookingResponse.class);
        bookingResponse.setBooking(allBookings);

        return ResponseEntity.ok(bookingResponse);
    }

    // TODO make sure for properties owner and tenant to have access their own booking
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {
        BookingDTO booking = bookingService.getBookingById(id);
        BookingResponse bookingResponse = BaseResponse.successResponse(BookingResponse.class);
        bookingResponse.setBooking(List.of(booking));
        return ResponseEntity.ok(bookingResponse);
    }

    @PreAuthorize("hasRole('TENANT')")
    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody BookingRequest bookingRequest) {
        bookingService.addBooking(bookingRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }


    //TODO - check again
    @PutMapping("/{bookingId}/approveBooking/{propertyOwnerId}")
    public ResponseEntity<String> approveBooking(
            @PathVariable Long bookingId,
            @PathVariable Long propertyOwnerId) {
        bookingService.approveBooking(bookingId, propertyOwnerId);
        return ResponseEntity.ok("Booking approved successfully.");
    }

    @PermitAll
    @GetMapping("/bookingStatuses")
    public ResponseEntity<List<String>> getAllBookingStatus() {
        List<String> bookingStatuses = Arrays.stream(BookingStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookingStatuses);
    }
}
