package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Activity;
import com.example.backendbobsfunland.model.Booking;
import com.example.backendbobsfunland.model.Instructor;
import com.example.backendbobsfunland.repository.ActivityRepository;
import com.example.backendbobsfunland.repository.BookingRepository;
import com.example.backendbobsfunland.repository.InstructorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingRESTControllerTest {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    InstructorRepository instructorRepository;

    @Test
    void saveBooking() {
        Activity activity = new Activity();
        activity.setName("ATV Kørsel");

        Instructor instructor = new Instructor();
        instructor.setEmail("kris@fundlan.dk");

        String date = "20-03-2022";
        String time = "13:10";
        int participants = 6;

        Booking booking = new Booking();
        booking.setActivity(activity);
        booking.setDate(date);
        booking.setTime(time);
        booking.setNrOfParticipants(participants);
        booking.setInstructor(instructor);

        bookingRepository.save(booking);
        Assertions.assertEquals(booking, bookingRepository.findById(1));
    }

}