package com.example.backendbobsfunland.RESTcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
public class IndexRESTController {


  @GetMapping("/index")
  public String homePage(){
    return "/index";
  }

}
