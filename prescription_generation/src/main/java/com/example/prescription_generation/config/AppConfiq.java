package com.example.prescription_generation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class AppConfiq {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
