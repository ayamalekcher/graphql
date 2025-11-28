package com.example.graphql_service.service;

import com.example.graphql_service.model.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceClient {

    private final RestTemplate restTemplate;

    @Value("${course.service.url}")
    private String courseUrl;

    public CourseServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Course> getAllCourses() {
        try {
            ResponseEntity<Course[]> response =
                    restTemplate.getForEntity(courseUrl, Course[].class);
            Course[] courses = response.getBody();
            return courses != null ? Arrays.asList(courses) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Course getCourseById(Long id) {
        return null; // غير مدعوم حاليا
    }
}
