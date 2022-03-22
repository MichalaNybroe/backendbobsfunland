package com.example.backendbobsfunland.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    private String email;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "accessLevel")
    private Access access;

    @OneToMany
    @JoinColumn(name = "email")
    @JsonBackReference
    private Set<Booking> bookings = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
