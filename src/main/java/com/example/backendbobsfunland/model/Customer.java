package com.example.backendbobsfunland.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    private String email;
    private String name;
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "customerEmail")
    @JsonBackReference
    private Set<Booking> bookings = new HashSet<>();
}
