package com.example.studentrest.dao;

import com.example.studentrest.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    EntityManager entityManager;

    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Student getStudentById(int studentId) {
        Student foundStudent = entityManager.find(Student.class, studentId);
        return foundStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);

        return typedQuery.getResultList();

    }

    @Override
    @Transactional
    public  void saveStudent(Student student){
        System.out.println("Saving student with name : " + student.getFirstName());
//        entityManager.merge(student);
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student foundStudent = entityManager.find(Student.class, id);
        System.out.println("Found Student : " + foundStudent.getFirstName());
        entityManager.remove(foundStudent);
    }
}
