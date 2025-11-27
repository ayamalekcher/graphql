package com.example.graphql_service.service;

import com.example.graphql_service.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentServiceClient {

    private final WebClient studentWebClient;

    public StudentServiceClient(WebClient studentWebClient) {
        this.studentWebClient = studentWebClient;
    }

    public List<Student> getAllStudents() {
        return studentWebClient.get()
                .retrieve()
                .bodyToFlux(Student.class)
                .collectList()
                .block();
    }

    public Student getStudentById(Long id) {
        return studentWebClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}
