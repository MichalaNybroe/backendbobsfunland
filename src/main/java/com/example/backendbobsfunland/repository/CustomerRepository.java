package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByEmail(String email);
}
