package com.example.graphql_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Bean عام لـ RestTemplate يمكن استخدامه في أي Service
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
