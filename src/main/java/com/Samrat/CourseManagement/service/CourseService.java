package com.Samrat.CourseManagement.service;

import com.Samrat.CourseManagement.models.CourseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    String createCourse (CourseModel courseModel) ;
    List<CourseModel> getCourse () ;
    String updateCourse (CourseModel courseModel, long id) ;
    List<?> getpartial() ;
}
