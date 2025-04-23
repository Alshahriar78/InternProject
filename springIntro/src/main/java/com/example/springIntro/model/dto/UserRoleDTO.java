package com.example.springIntro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private Long id;
    private String roleName;
    private String description;
    private boolean canCreateBlog;
    private boolean canViewBlog;
    private boolean canEditBlog;
    private boolean canDeleteBlog;
}