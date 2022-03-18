package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Instructor;
import com.example.backendbobsfunland.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class LoginRESTController {

  @Autowired
  InstructorRepository instructorRepository;

  @PostMapping("/login")
  public Boolean login(HttpSession session, HttpServletResponse response, @RequestBody Instructor instructor) throws IOException {

    Instructor inst = instructorRepository.findByEmail(instructor.getEmail());

     if(inst.getEmail().equals(instructor.getEmail()) && inst.getPassword().equals(instructor.getPassword())){

       //session.setAttribute("email", inst.getEmail());

       //response.sendRedirect("/index");
       return true;

     }
     return false;
  }



}
