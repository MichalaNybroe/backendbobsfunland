package com.example.backendbobsfunland.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

@Entity
public class Booking {

    @Id
    private int orderNumber;
    @ManyToOne
    @JoinColumn(name = "name")
    private Activity activity;
    private Date date;
    private Time time;
    private int nrOfParticipants;


    @ManyToOne
    @JoinColumn(name = "email")
    private Instructor instructor;



}
