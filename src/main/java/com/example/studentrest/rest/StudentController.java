package com.example.studentrest.rest;

import com.example.studentrest.entity.Student;
import com.example.studentrest.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentServices studentServices;
    StudentController(StudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId){
            Student foundStudent = studentServices.findById(studentId);
            if(foundStudent == null)
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(foundStudent, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentServices.findAll(), HttpStatus.ACCEPTED);
    }
//
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student newStudent){
            return new ResponseEntity<>(studentServices.save(newStudent), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId){
        studentServices.deleteById(studentId);
        return new ResponseEntity<>("Student Deleted with id - " + studentId, HttpStatus.OK);
    }

}
