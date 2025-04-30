package com.example.springIntro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private String roleName;
    private String description;
    private Set<Long> userIds;
}