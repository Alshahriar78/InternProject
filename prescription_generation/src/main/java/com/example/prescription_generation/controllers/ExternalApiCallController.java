package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.ExternalApiCallDTO;
import com.example.prescription_generation.service.ExternalApiCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ExternalApiCallController {

    private final ExternalApiCallService externalApiCallService;

    @GetMapping("/REST/consume-external-API")
    public ResponseEntity<?> getExternalApiCall() {
        try {
            List<ExternalApiCallDTO> posts = externalApiCallService.getAllPosts();
            return ResponseEntity.ok(posts);
        }catch (Exception e){
            System.out.println("Exception form get api controller = "+e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}
