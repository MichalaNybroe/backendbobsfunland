package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Booking;
import com.example.backendbobsfunland.model.Customer;
import com.example.backendbobsfunland.repository.BookingRepository;
import com.example.backendbobsfunland.repository.CustomerRepository;
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

    @Autowired
    CustomerRepository customerRepository;


    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking) {
        Customer customer = customerRepository.findByEmail(booking.getCustomer().getEmail());

        if (customer == null) {
            customerRepository.save(booking.getCustomer());
        }

        return bookingRepository.save(booking);
    }

    @PostMapping("/search")
    public List<Booking> searchBookings(@RequestBody String email) {
        Customer customer = customerRepository.findByEmail(email);
        return bookingRepository.findByCustomer(customer);
    }

    @GetMapping("/booking")
    public List<Booking> readAllBookings() {
        return bookingRepository.findAll(Sort.by("date").ascending().and(Sort.by("time").ascending()));
    }

    @DeleteMapping("/booking")
    public void deleteBooking(@RequestBody Booking booking) {
        bookingRepository.delete(booking);
    }
}
