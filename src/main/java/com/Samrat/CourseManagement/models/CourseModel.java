package com.Samrat.CourseManagement.models;

import lombok.Data;

@Data
public class CourseModel {
    private  Long id ;
    private String name;
    private String subject;
    private int numberOfChapters;
    private int numberOfClasses;
    private String type;
    private String learnMode;
    private String creatorRole;
}
