package com.example.springIntro.service;

import com.example.springIntro.model.dto.UserRoleDTO;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.entity.UserRole;
import com.example.springIntro.model.mapper.UserRoleMapper;
import com.example.springIntro.repo.UserRepository;
import com.example.springIntro.repo.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final UserRoleMapper userRoleMapper;

    public UserRoleDTO createRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleMapper.toEntity(userRoleDTO);
        if (userRoleDTO.getUserIds() != null) {
            Set<User> users = userRoleDTO.getUserIds().stream()
                    .map(id -> userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id)))
                    .collect(Collectors.toSet());
            userRole.setUsers(users);
        }
        userRole = userRoleRepository.save(userRole);
        return userRoleMapper.toDTO(userRole);
    }

    public UserRoleDTO getRoleById(Long id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return userRoleMapper.toDTO(userRole);
    }

    public void deleteRoleById(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new RuntimeException("Role not found with id: " + id);
        }
        userRoleRepository.deleteById(id);
    }

    public UserRoleDTO updateRole(Long id, UserRoleDTO userRoleDTO) {
        UserRole existingRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        existingRole.setRoleName(userRoleDTO.getRoleName());
        existingRole.setDescription(userRoleDTO.getDescription());

        if (userRoleDTO.getUserIds() != null) {
            Set<User> users = new HashSet<>();
            for (Long userId : userRoleDTO.getUserIds()) {
                User user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found: " + userId));
                users.add(user);
            }
            existingRole.setUsers(users);
        }
        UserRole updatedRole = userRoleRepository.save(existingRole);
        return userRoleMapper.toDTO(updatedRole);
    }
}

