package com.fracta7.crud.data.repository;

import com.fracta7.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllByFirstNameContaining(String p);
}
