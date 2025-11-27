package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceClient {

    private final WebClient webClient;

    public StudentServiceClient(@Qualifier("studentWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Map<String, Object>> getAllStudents() {
        return webClient.get()
                .uri("/students")
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

    public Map<String, Object> getStudentById(Long id) {
        return webClient.get()
                .uri("/students/{id}", id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
