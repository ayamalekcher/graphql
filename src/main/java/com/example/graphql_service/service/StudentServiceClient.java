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
public class StudentServiceClient {

    @Value("${graphql.students.url}")

    private String studentServiceUrl; 

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, Object>> getAllStudents() {
        ResponseEntity<List<Map<String, Object>>> response =
                restTemplate.exchange(
                        studentServiceUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Map<String, Object>>>() {}
                );

        return response.getBody();
    }

    public Map<String, Object> getStudentById(Long id) {

        String baseUrl = studentServiceUrl.replace("/getAll", "");

        ResponseEntity<Map<String, Object>> response =
                restTemplate.exchange(
                        baseUrl + "/" + id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Map<String, Object>>() {}
                );

        return response.getBody();
    }
}
