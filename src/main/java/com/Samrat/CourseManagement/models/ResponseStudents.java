package com.Samrat.CourseManagement.models;

import lombok.Data;

@Data
public class ResponseStudents {
    private String name;
    private String subject;

    public ResponseStudents(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    // getters and setters
}
