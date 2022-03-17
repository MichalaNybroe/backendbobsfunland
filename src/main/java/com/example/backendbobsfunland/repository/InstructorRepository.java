package com.example.backendbobsfunland.repository;

import com.example.backendbobsfunland.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,String> {

  Instructor findByName(String name);
}
