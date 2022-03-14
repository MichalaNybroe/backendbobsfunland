package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
}
