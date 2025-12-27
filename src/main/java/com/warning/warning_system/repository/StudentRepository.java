package com.warning.warning_system.repository;

import com.warning.warning_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByStudentNameContaining(String name);
    List<Student> findByCollegeId(Integer collegeId);


}