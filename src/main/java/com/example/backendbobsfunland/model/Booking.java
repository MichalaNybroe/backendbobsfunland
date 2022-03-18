package com.example.backendbobsfunland.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    private int orderNumber;
    @ManyToOne
    @JoinColumn(name = "name")
    private Activity activity;
    private String date;
    private String time;
    private int nrOfParticipants;
    private String customerName;
    private String customerEmail;
    private String customerPhone;


    @ManyToOne
    @JoinColumn(name = "email")
    private Instructor instructor;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(int nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String bookName) {
        this.customerName = bookName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String bookEmail) {
        this.customerEmail = bookEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String bookPhone) {
        this.customerPhone = bookPhone;
    }
}

