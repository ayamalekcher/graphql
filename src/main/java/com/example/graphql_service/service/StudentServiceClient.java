package com.example.graphql_service.service;

import com.example.graphql_service.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class StudentServiceClient {

    private final WebClient webClient;

    public StudentServiceClient(@Qualifier("studentWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Student> getAllStudents() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Student.class)
                .collectList()
                .block();
    }

    public Student getStudentById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}
