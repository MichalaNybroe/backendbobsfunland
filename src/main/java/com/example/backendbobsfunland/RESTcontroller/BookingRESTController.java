package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Booking;
import com.example.backendbobsfunland.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookingRESTController {

    @Autowired
    BookingRepository bookingRepository;


    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Booking> searchBookings(@RequestBody String email) {
        return bookingRepository.searchBookingByCustomerEmail(email);
    }

    @GetMapping("/booking")
    public List<Booking> readAllBookings() {
        return bookingRepository.findAll(Sort.by("date").ascending().and(Sort.by("time").ascending()));
    }

    @DeleteMapping("/booking")
    public void deleteBooking(@RequestBody Booking booking){
        bookingRepository.deleteByCustomerPhone(booking.getCustomerPhone());
    }
}
