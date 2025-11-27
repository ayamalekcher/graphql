package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceClient {

    @Autowired
    private WebClient studentWebClient;

    public List<Map<String, Object>> getAllStudents() {
        return studentWebClient.get()
                .uri("/students")
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();
    }

    public Map<String, Object> getStudentById(Long id) {
        return studentWebClient.get()
                .uri("/students/" + id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
