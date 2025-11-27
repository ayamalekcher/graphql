package com.example.graphql_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${graphql.students.url}")
    private String studentsUrl;

    @Value("${graphql.courses.url}")
    private String coursesUrl;

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
