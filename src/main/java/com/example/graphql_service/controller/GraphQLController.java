package com.example.graphql_service.controller;

import com.example.graphql_service.model.Student;
import com.example.graphql_service.model.Course;
import com.example.graphql_service.service.StudentServiceClient;
import com.example.graphql_service.service.CourseServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GraphQLController {

    @Autowired
    private StudentServiceClient studentClient;

    @Autowired
    private CourseServiceClient courseClient;

    // --- Queries pour les étudiants ---
    @QueryMapping
    public List<Student> students() {
        return studentClient.getAllStudents();
    }

    @QueryMapping
    public Student studentById(@Argument Long id) {
        return studentClient.getStudentById(id);
    }

    // --- Queries pour les cours ---
    @QueryMapping
    public List<Course> courses() {
        return courseClient.getAllCourses();
    }

    @QueryMapping
    public Course courseById(@Argument Long id) {
        return courseClient.getCourseById(id);
    }

    // --- StudentCourses ---
    @QueryMapping
    public Map<String, Object> studentCourses(@Argument Long id) {
        Map<String, Object> response = new HashMap<>();

        Student student = studentClient.getStudentById(id);
        response.put("student", student);

        List<Course> courses = courseClient.getAllCourses(); // Pour l'instant on récupère tous les cours
        response.put("courses", courses);

        return response;
    }
}
