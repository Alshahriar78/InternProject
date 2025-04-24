//package com.example.springIntro.model.mapper;
//
//
//import com.example.springIntro.model.dto.UserRoleDTO;
//import com.example.springIntro.model.entity.UserRole;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserRoleMapper {
//
//    /**
//     * Convert UserRole entity to UserRoleDTO
//     */
//    public UserRoleDTO toDTO(UserRole userRole) {
//        if (userRole == null) {
//            return null;
//        }
//
//        UserRoleDTO dto = new UserRoleDTO();
//        dto.setId(userRole.getId());
//        dto.setRoleId(userRole.getRole() != null ? userRole.getRole().getId() : null);
//        dto.setRoleName(userRole.getRole() != null ? userRole.getRole().getRole() : null);
//        dto.setRoleDescription(userRole.getRole() != null ? userRole.getRole().getDescription() : null);
//
//        return dto;
//    }
//
//
//    public UserRoleDTO toResponseDTO(UserRoleDTO userRole) {
//        if (userRole == null) {
//            return null;
//        }
//
//        UserRoleDTO responseDTO = new UserRoleDTO();
//        responseDTO.setId(userRole.getId());
//
//        if (userRole.getRole() != null) {
//            responseDTO.setRoleId(userRole.getRole().getId());
//            responseDTO.setRoleName(userRole.getRole().getRole());
//            responseDTO.setRoleDescription(userRole.getRole().getDescription());
//        }
//
//        if (userRole.getUsers() != null && !userRole.getUsers().isEmpty()) {
//            responseDTO.setUserCount(userRole.getUsers().size());
//            responseDTO.setUserIds(userRole.getUsers().stream()
//                    .map(User::getId)
//                    .collect(Collectors.toSet()));
//        } else {
//            responseDTO.setUserCount(0);
//            responseDTO.setUserIds(Set.of());
//        }
//
//        return responseDTO;
//    }
//
//}