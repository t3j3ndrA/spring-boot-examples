package com.example.studentrest.services;

import com.example.studentrest.dao.StudentRepository;
import com.example.studentrest.entity.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices {
    StudentRepository studentRepository;

    @Autowired
    StudentServicesImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(int id){
        return studentRepository.findById(id).get();
    }

}
