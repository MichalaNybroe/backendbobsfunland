package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Instructor;
import com.example.backendbobsfunland.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class InstrcutorRESTController {

    @Autowired
    InstructorRepository instructorRepository;

    @GetMapping("/instructor")
    public List<Instructor> readAllInstructors() {
        return instructorRepository.findAll();
    }
}
