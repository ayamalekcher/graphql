package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceClient {

    @Value("${course.service.url}")
    private String courseServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, Object>> getAllCourses() {
        return restTemplate.getForObject(courseServiceUrl, List.class);
    }

    public Map<String, Object> getCourseById(Long id) {
        return restTemplate.getForObject(courseServiceUrl + "/" + id, Map.class);
    }
}
