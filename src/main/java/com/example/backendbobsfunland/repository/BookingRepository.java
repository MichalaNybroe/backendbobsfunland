package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Booking;
import com.example.backendbobsfunland.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAll(Sort sort);

    List<Booking> findByCustomer(Customer customer);

    Booking findByOrderNumber(int orderNumber);
}
