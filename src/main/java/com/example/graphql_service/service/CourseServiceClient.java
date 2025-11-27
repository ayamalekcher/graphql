package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceClient {

    @Autowired
    private WebClient courseWebClient;

    public List<Map<String, Object>> getAllCourses() {
        return courseWebClient.get()
                .uri("/courses")
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();
    }

    public Map<String, Object> getCourseById(Long id) {
        return courseWebClient.get()
                .uri("/courses/" + id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
