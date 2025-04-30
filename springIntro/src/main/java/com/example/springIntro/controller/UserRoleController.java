package com.example.springIntro.controller;

import com.example.springIntro.model.dto.UserRoleDTO;
import com.example.springIntro.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO createdRole = userRoleService.createRole(userRoleDTO);
        return ResponseEntity.ok(createdRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRole(@PathVariable Long id) {
        UserRoleDTO role = userRoleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        userRoleService.deleteRoleById(id);
        return ResponseEntity.ok("Role deleted with id: " + id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable Long id, @RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO updatedRole = userRoleService.updateRole(id, userRoleDTO);
        return ResponseEntity.ok(updatedRole);
    }
}

