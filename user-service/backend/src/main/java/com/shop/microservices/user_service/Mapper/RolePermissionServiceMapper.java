package com.shop.microservices.user_service.Mapper;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.RolePermission;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolePermissionServiceMapper {

    //RolePermissionRequest to the Entity (Save)
    public RolePermissionResponseDTO toEntity(RolePermissionRequestDTO rolePermissionRequestDTO){
        if(rolePermissionRequestDTO == null){
            return null;
        }
        return RolePermissionResponseDTO.builder()
                .permissionId(rolePermissionRequestDTO.getPermissionId())
                .role(RoleEnum.valueOf(rolePermissionRequestDTO.getRole().toString()))
                .build();
    }

    //Entity to the RolePermissionResponseDTO (Fetch)
    public RolePermissionResponseDTO toDto(RolePermission rolePermission){
        if (rolePermission == null) {
            return null;
        }
        return RolePermissionResponseDTO.builder()
                .id(rolePermission.getId())
                .permissionId(rolePermission.getPermission().getId())
                .role(rolePermission.getRole().getRole())
                .createdDate(LocalDateTime.ofInstant(rolePermission.getCreatedDate(), ZoneId.systemDefault()))
                .lastModifiedDate(LocalDateTime.ofInstant(rolePermission.getLastModifiedDate(), ZoneId.systemDefault()))
                .createdBy(rolePermission.getCreatedBy())
                .lastModifiedBy(rolePermission.getLastModifiedBy())
                .build();
    }

    //Map All the RolePermissions to the DTO
    public List<RolePermissionResponseDTO> getAllRolePermissions(List<RolePermission> rolePermissions) {
        if (rolePermissions == null) {
            return null;
        }
        return rolePermissions.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
