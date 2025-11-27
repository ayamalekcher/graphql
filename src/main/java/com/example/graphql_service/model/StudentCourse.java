package com.example.graphql_service.model;

import java.util.List;

public class StudentCourse {

    private Student student;
    private List<Course> courses;

    public StudentCourse() {}

    public StudentCourse(Student student, List<Course> courses) {
        this.student = student;
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
