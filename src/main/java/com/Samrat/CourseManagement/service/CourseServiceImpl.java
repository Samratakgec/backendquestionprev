package com.Samrat.CourseManagement.service;

import com.Samrat.CourseManagement.entity.CourseEntity;
import com.Samrat.CourseManagement.models.CourseModel;
import com.Samrat.CourseManagement.models.ResponseStudents;
import com.Samrat.CourseManagement.repository.CourseRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepo courseRepo ;
    @Override
    public String createCourse(CourseModel courseModel) {
        if (Objects.equals(courseModel.getCreatorRole(), "courseCreator")) {
            CourseEntity courseEntity = new CourseEntity();
            BeanUtils.copyProperties(courseModel, courseEntity);

            courseRepo.save(courseEntity) ;
            return "created successfully";
        }
        return "Access Denied" ;
    }

    @Override
    public List<CourseModel> getCourse() {
        List<CourseEntity> courseEntityList = courseRepo.findAll();
        List<CourseModel> courseModels = new ArrayList<>();

        for (CourseEntity courseEntity : courseEntityList) {
            CourseModel courseModel = new CourseModel();
            BeanUtils.copyProperties(courseEntity, courseModel);
            courseModels.add(courseModel);
        }
        return courseModels;
    }




//    public  List<ResponseStudents> getCourseForStudents (String name, String subject){
//
//        return courseRepo.findByNameAndSubject(name,subject)  ;
//    }

    @Override
    public String updateCourse(CourseModel courseModel, long id) {
        if (Objects.equals(courseModel.getCreatorRole(), "courseCreator"))
        {
        CourseEntity courseEntity = courseRepo.findById(id).get() ;

        courseEntity.setName(courseModel.getName());
        courseEntity.setSubject(courseModel.getSubject());
        courseEntity.setNumberOfClasses(courseModel.getNumberOfClasses());
        courseEntity.setNumberOfChapters(courseModel.getNumberOfChapters());
        courseEntity.setType(courseModel.getType());
        courseEntity.setLearnMode(courseModel.getLearnMode());
        courseEntity.setCreatorRole("courseCreator");


        courseRepo.save(courseEntity) ;
        return "updated successfully";
        }
        return "Access Denied" ;
    }

    @Override
    public List<?> getpartial() {
        return courseRepo.findByNameAndSubject();
    }
}
