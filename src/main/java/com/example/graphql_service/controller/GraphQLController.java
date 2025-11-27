package com.example.graphql_service.controller;

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

    @QueryMapping
    public List<Map<String, Object>> students() {
        return studentClient.getAllStudents();
    }

    @QueryMapping
    public Map<String, Object> studentById(@Argument Long id) {
        return studentClient.getStudentById(id);
    }

    @QueryMapping
    public List<Map<String, Object>> courses() {
        return courseClient.getAllCourses();
    }

    @QueryMapping
    public Map<String, Object> courseById(@Argument Long id) {
        return courseClient.getCourseById(id);
    }

    @QueryMapping
    public Map<String, Object> studentCourses(@Argument Long id) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> student = studentClient.getStudentById(id);
        response.put("student", student);

        // Pour l'instant on récupère tous les cours
        List<Map<String, Object>> courses = courseClient.getAllCourses();
        response.put("courses", courses);

        return response;
    }
}
