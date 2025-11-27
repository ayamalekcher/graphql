package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceClient {

    private final WebClient webClient;

    public CourseServiceClient(@Qualifier("courseWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Map<String, Object>> getAllCourses() {
        return webClient.get()
                .uri("/courses")
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

    public Map<String, Object> getCourseById(Long id) {
        return webClient.get()
                .uri("/courses/{id}", id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
