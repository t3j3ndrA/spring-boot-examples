package com.example.studentrest.dao;

import com.example.studentrest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
