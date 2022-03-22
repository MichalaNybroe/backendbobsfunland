package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Instructor;
import com.example.backendbobsfunland.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class LoginRESTController {

    @Autowired
    InstructorRepository instructorRepository;

    @PostMapping("/login")
    public Instructor login(@RequestBody Instructor instructor) throws IOException {

        Instructor inst = instructorRepository.findByEmail(instructor.getEmail());

        if (inst.getEmail().equals(instructor.getEmail()) && inst.getPassword().equals(instructor.getPassword())) {
            return inst;
        }

        return null;
    }
}
