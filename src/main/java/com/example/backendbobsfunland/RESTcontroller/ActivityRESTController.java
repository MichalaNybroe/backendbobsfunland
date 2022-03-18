package com.example.backendbobsfunland.RESTcontroller;

import com.example.backendbobsfunland.model.Activity;
import com.example.backendbobsfunland.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ActivityRESTController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/activity")
    public List<Activity> readAllactivities() {
        return activityRepository.findAll();
    }

    @GetMapping("/activity/{name}")
    public Activity readActivityByName(@PathVariable String name) {
       return activityRepository.findByName(name);
    }
}
