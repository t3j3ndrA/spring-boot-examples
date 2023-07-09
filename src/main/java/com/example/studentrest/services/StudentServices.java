package com.example.studentrest.services;

import com.example.studentrest.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentServices {
    public List<Student> findAll();
    public Student save(Student s);

    public void deleteById(int id);

    public Student findById(int id);
}
