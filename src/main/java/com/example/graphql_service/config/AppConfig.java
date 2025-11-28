package com.example.graphql_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    private final String studentsUrl;
    private final String coursesUrl;

    public AppConfig(
            @Value("${student.service.url}") String studentsUrl,
            @Value("${course.service.url}") String coursesUrl) {
        this.studentsUrl = studentsUrl;
        this.coursesUrl = coursesUrl;
    }

    @Bean(name = "studentWebClient")
    public WebClient studentWebClient() {
        return WebClient.builder()
                .baseUrl(studentsUrl)
                .build();
    }

    @Bean(name = "courseWebClient")
    public WebClient courseWebClient() {
        return WebClient.builder()
                .baseUrl(coursesUrl)
                .build();
    }
}
