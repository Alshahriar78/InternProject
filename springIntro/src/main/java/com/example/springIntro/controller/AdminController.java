package com.example.springIntro.controller;

import com.example.springIntro.model.entity.User;
import com.example.springIntro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        // এখানে আপনি service/database থেকে সব ইউজার এনে return করবেন
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
}
