package com.example.backendbobsfunland.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Access {

    @Id
    private Integer accessLevel;
    private String accessName;

    @OneToMany
    @JoinColumn(name = "accessLevel")
    @JsonBackReference
    private Set<Instructor> instructors = new HashSet<>();

}
