package com.Samrat.CourseManagement.controllers;

import com.Samrat.CourseManagement.models.CourseModel;
import com.Samrat.CourseManagement.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping ("course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
    @PostMapping ("c")
    String create(@RequestBody CourseModel courseModel)
    {
        return courseService.createCourse(courseModel) ;
    }

    @GetMapping ("c/teacher")
    List<?> get ()
    {

          //  System.out.println("Calling getCourse");
            return courseService.getCourse();

    }
    @GetMapping ("c/student")
    List<?> getlil ()
    {
        return courseService.getpartial();
    }

    @PutMapping ("c/{id}")
    String update (@RequestBody CourseModel courseModel, @PathVariable Long id)
    {
        return courseService.updateCourse(courseModel,id) ;
    }
}
