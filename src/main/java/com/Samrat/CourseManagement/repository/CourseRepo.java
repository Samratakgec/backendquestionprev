package com.Samrat.CourseManagement.repository;

import com.Samrat.CourseManagement.entity.CourseEntity;
import com.Samrat.CourseManagement.models.ResponseStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity,Long> {
    @Query("SELECT new com.Samrat.CourseManagement.models.ResponseStudents(c.name, c.subject) FROM CourseEntity c")
   public List<?> findByNameAndSubject() ;
}
