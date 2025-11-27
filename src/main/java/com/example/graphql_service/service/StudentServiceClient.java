package com.example.graphql_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceClient {

    @Value("${student.service.url}")
    private String studentServiceUrl; // = http://localhost:8888/student/getAll

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, Object>> getAllStudents() {
        // هذا endpoint يرجع جميع الطلاب
        return restTemplate.getForObject(studentServiceUrl, List.class);
    }

    public Map<String, Object> getStudentById(Long id) {
        // هذا endpoint خاص بطالب واحد
        String baseUrl = studentServiceUrl.replace("/getAll", ""); // نحيد /getAll باش نستعمل /{id}
        return restTemplate.getForObject(baseUrl + "/" + id, Map.class);
    }
}
