package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAll(Sort sort);

    List<Booking> findByCustomerEmail(String email);
}
