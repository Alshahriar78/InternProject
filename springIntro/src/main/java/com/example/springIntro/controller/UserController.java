package com.example.springIntro.controller;


import com.example.springIntro.model.dto.UserDTO;
import com.example.springIntro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO dto) {
        userService.save(dto);
        return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        return userService.seachByID(id);
    }

    @DeleteMapping("/api/v1/user/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {
        UserDTO updated = userService.updateUser(id, dto);
        return ResponseEntity.ok("Successfully User Updated...");
    }
}