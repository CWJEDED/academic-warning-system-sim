package com.warning.warning_system.repository;

import com.warning.warning_system.entity.CourseTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTeacherRepository extends JpaRepository<CourseTeacher, Integer> {
    List<CourseTeacher> findByTeaId(Integer teaId);
    List<CourseTeacher> findByTeaIdIn(List<Integer> teaIds);
}