package com.example.studentrest.rest;

import com.example.studentrest.dao.StudentDAO;
import com.example.studentrest.entity.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentDAO studentDAO;

    StudentController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId){
            Student foundStudent = studentDAO.getStudentById(studentId);
            if(foundStudent == null)
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(foundStudent, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentDAO.getAllStudents(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student newStudent){
            studentDAO.saveStudent(newStudent);
            return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId){
        studentDAO.deleteStudent(studentId);
        return new ResponseEntity<>("Student Deleted.", HttpStatus.OK);
    }

}
