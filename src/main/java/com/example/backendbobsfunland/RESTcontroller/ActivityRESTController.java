package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Activity;
import com.example.backendbobsfunland.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ActivityRESTController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/Activity")
    public List<Activity> readAllactivities() {
        return activityRepository.findAll();
    }
}
