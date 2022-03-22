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
    @JoinColumn(name = "customer_email")
    @JsonBackReference
    private Set<Booking> bookings = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String customer_email) {
        this.email = customer_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
