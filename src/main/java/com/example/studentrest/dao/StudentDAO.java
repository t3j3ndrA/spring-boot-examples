package com.example.studentrest.dao;

import com.example.studentrest.entity.Student;

import java.util.List;


public interface StudentDAO {
    public Student getStudentById(int studentId);
    public List<Student> getAllStudents();

    public void saveStudent(Student student);

    public void deleteStudent(int id);
}
