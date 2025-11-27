package com.example.graphql_service.model;

public class Course {

    private int id;
    private String name;
    private String instructor;
    private String category;
    private String schedule;

    public Course() {}

    public Course(int id, String name, String instructor, String category, String schedule) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.category = category;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
