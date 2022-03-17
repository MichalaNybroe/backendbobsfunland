package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Instructor;
import com.example.backendbobsfunland.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
public class LoginRESTController {

  @Autowired
  InstructorRepository instructorRepository;

  @CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
  @PostMapping("/login")
  public void login(HttpSession session, HttpServletResponse response, @RequestBody Instructor instructor) throws IOException {
    //response.sendRedirect("/index");
    Instructor inst = instructorRepository.findByName("email");

    //System.out.println(inst);

    //return instructorRepository.findByName("email");

    if(inst.getEmail().equals(instructor.getEmail()) && inst.getPassword().equals(instructor.getPassword())){

       //session.setAttribute("email", inst.getEmail());
       response.sendRedirect("/index");
     }
  }
}
