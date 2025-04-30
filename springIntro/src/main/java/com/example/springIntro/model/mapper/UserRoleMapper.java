package com.example.springIntro.model.mapper;

import com.example.springIntro.model.dto.UserRoleDTO;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.entity.UserRole;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserRoleMapper {

    public UserRoleDTO toDTO(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        UserRoleDTO dto = new UserRoleDTO();

        dto.setRoleName(userRole.getRoleName());
        dto.setDescription(userRole.getDescription());
        if (userRole.getUsers() != null) {
            Set<Long> userIds = userRole.getUsers().stream()
                    .map(User::getId)
                    .collect(Collectors.toSet());
            dto.setUserIds(userIds);
        }
        return dto;
    }

    public UserRole toEntity(UserRoleDTO dto) {
        if (dto == null) {
            return null;
        }
        UserRole userRole = new UserRole();
        userRole.setId(userRole.getId());
        userRole.setRoleName(dto.getRoleName());
        userRole.setDescription(dto.getDescription());

        // users mapping এখানে করা হয়নি কারণ service layer থেকে সেট করা হবে (db fetch করে)
        return userRole;
    }
}
