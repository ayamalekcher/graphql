package com.example.graphql_service.service;

import com.example.graphql_service.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CourseServiceClient {

    private final WebClient courseWebClient;

    public CourseServiceClient(WebClient courseWebClient) {
        this.courseWebClient = courseWebClient;
    }

    public List<Course> getAllCourses() {
        return courseWebClient.get()
                .retrieve()
                .bodyToFlux(Course.class)
                .collectList()
                .block();
    }

    public Course getCourseById(Long id) {
        return courseWebClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Course.class)
                .block();
    }
}
