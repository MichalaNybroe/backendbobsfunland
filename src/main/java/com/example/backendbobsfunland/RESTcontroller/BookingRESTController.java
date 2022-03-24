package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Booking;
import com.example.backendbobsfunland.model.Customer;
import com.example.backendbobsfunland.repository.BookingRepository;
import com.example.backendbobsfunland.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.Optional;

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

        Booking b = bookingRepository.findByOrderNumber(booking.getOrderNumber());

        if (b == null) {
            sendEmail(booking.getCustomer().getEmail());
        }
    }

    public void sendEmail(String to) {
        // Sender's email ID needs to be mentioned
        String from = System.getenv("email");

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, System.getenv("mailPassword"));
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}