package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.ExternalApiCallDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalApiCallService {


        private final RestTemplate restTemplate;

        public List<ExternalApiCallDTO> getAllPosts() {

            String url = "https://prescription-generation.free.beeceptor.com/todos";

            ResponseEntity<List<ExternalApiCallDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ExternalApiCallDTO>>() {}
            );

            return response.getBody();
        }

}
