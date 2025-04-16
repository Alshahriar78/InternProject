package com.example.springIntro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @GetMapping("/user")
    private ResponseEntity<String> all_user()
    {
        return ResponseEntity.ok("all user");
    }
}
