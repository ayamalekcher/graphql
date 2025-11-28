package com.example.graphql_service.service;

import com.example.graphql_service.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceClient {

    private final RestTemplate restTemplate;

    @Value("${student.service.url}")
    private String studentUrl;

    public StudentServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Student> getAllStudents() {
        try {
            ResponseEntity<Student[]> response =
                    restTemplate.getForEntity(studentUrl, Student[].class);
            Student[] students = response.getBody();
            return students != null ? Arrays.asList(students) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Student getStudentById(Long id) {
        try {
            String url = studentUrl.replace("/getAll", "") + "/" + id;
            return restTemplate.getForObject(url, Student.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
