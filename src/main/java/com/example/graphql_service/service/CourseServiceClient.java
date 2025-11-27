package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceClient {

    @Value("${graphql.courses.url}")

    private String courseServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, Object>> getAllCourses() {
        ResponseEntity<List<Map<String, Object>>> response =
                restTemplate.exchange(
                        courseServiceUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Map<String, Object>>>() {}
                );

        return response.getBody();
    }

    public Map<String, Object> getCourseById(Long id) {
        ResponseEntity<Map<String, Object>> response =
                restTemplate.exchange(
                        courseServiceUrl + "/" + id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Map<String, Object>>() {}
                );

        return response.getBody();
    }
}
