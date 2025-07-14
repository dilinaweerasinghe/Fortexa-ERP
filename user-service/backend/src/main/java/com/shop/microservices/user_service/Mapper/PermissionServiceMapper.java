package com.shop.microservices.user_service.Mapper;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Model.Permission;

import java.time.LocalDateTime;
import java.util.List;

public class PermissionServiceMapper {

    //Map PermissionRequest to Permission (Save)
    public Permission toEntity(PermissionRequestDTO permissionRequestDTO){
        if(permissionRequestDTO == null) {
            return null;
        }

        return Permission.builder()
                .permission(permissionRequestDTO.getPermission())
                .description(permissionRequestDTO.getDescription())
                .build();
    }

    //Map Permission to PermissionResponse (fetch)
    public PermissionResponseDTO toDto(Permission permission) {
        if(permission == null) {
            return null;
        }
        return PermissionResponseDTO.builder()
                .permission(permission.getPermission())
                .id(permission.getId())
                .createdBy(permission.getCreatedBy())
                .createdDate(LocalDateTime.from(permission.getCreatedDate()))
                .lastModifiedBy(permission.getLastModifiedBy())
                .lastModifiedDate(LocalDateTime.from(permission.getLastModifiedDate()))
                .build();
    }

    //Map  all Permissions
    List<PermissionResponseDTO> getAllPermissions(List<Permission> permissions) {
        if(permissions == null) {
            return null;
        }

        return permissions.stream()
                .map(this::toDto)
                .toList();
    }

    //Map All permisions to DTO
    public List<PermissionResponseDTO> toDtoList(List<Permission> permissions) {
        if(permissions == null || permissions.isEmpty()) {
            return List.of();
        }
        return permissions.stream()
                .map(this::toDto)
                .toList();
    }
}
