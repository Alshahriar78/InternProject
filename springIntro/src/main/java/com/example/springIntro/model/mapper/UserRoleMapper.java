package com.example.springIntro.model.mapper;


import com.example.springIntro.model.dto.UserRoleDTO;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class UserRoleMapper {
    private static UserRoleDTO dto = new UserRoleDTO();
    private static UserRole userRole = new UserRole();

    public UserRoleDTO toDto(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        UserRoleDTO dto = new UserRoleDTO();
        dto.setId(userRole.getId());
        dto.setRoleName(userRole.getRoleName());
        dto.setDescription(userRole.getDescription());

        if (userRole.getUsers() != null && !userRole.getUsers().isEmpty()) {
            Optional<User> anyUser = userRole.getUsers().stream().findFirst();
            anyUser.ifPresent(user -> dto.setUserId(user.getId()));
        }

        return dto;
    }
    public UserRole toEntity(UserRoleDTO dto) {
        if (dto == null) {
            return null;
        }

        UserRole userRole = new UserRole();
        userRole.setId(dto.getId());
        userRole.setRoleName(dto.getRoleName());
        userRole.setDescription(dto.getDescription());

        if (dto.getUserId() != null) {
            User user = new User();
            user.setId(dto.getUserId());
            userRole.setUsers(Collections.singleton(user));
        } else {
            userRole.setUsers(Collections.emptySet());
        }

        return userRole;
    }
}