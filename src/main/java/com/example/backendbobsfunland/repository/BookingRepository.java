package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
