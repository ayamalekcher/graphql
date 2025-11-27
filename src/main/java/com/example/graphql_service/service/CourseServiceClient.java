package com.example.graphql_service.service;

import com.example.graphql_service.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class CourseServiceClient {

    private final WebClient webClient;

    public CourseServiceClient(@Qualifier("courseWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Course> getAllCourses() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Course.class)
                .collectList()
                .block();
    }

    public Course getCourseById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Course.class)
                .block();
    }
}
