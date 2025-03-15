package group3_real_estate_rental_system.Booking.dto;

import group3_real_estate_rental_system.common.BaseResponse;

import java.util.List;

public class BookingResponse extends BaseResponse {

    private List<BookingDTO> booking;

    public List<BookingDTO> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingDTO> booking) {
        this.booking = booking;
    }
}
