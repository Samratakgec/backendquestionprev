package com.Samrat.CourseManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "Courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private String name;
    private String subject;
    private int numberOfChapters;
    private int numberOfClasses;
    private String type;
    private String learnMode;
    private String creatorRole;
}
