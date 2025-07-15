package com.shop.microservices.user_service.Mapper;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.Permission;
import com.shop.microservices.user_service.Model.Role;
import com.shop.microservices.user_service.Model.RolePermission;
import com.shop.microservices.user_service.Repository.IPermissionRepository;
import com.shop.microservices.user_service.Repository.IRoleRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolePermissionServiceMapper {
    private final IPermissionRepository IPermissionRepository;
    private final IRoleRepository IRoleRepository;

    public RolePermissionServiceMapper(IPermissionRepository iPermissionRepository, IRoleRepository iRoleRepository) {
        IPermissionRepository = iPermissionRepository;
        IRoleRepository = iRoleRepository;
    }

    //RolePermissionRequest to the Entity (Save)
    public RolePermission toEntity(RolePermissionRequestDTO rolePermissionRequestDTO){

        System.out.println("The rolePermissionRequestDTO is"+rolePermissionRequestDTO.getRole());
        if(rolePermissionRequestDTO == null){
            return null;
        }
        Permission permission = IPermissionRepository.findById(rolePermissionRequestDTO.getPermissionId())
                .orElseThrow(() -> new RuntimeException("Permission not found with ID: " + rolePermissionRequestDTO.getPermissionId()));

        Role role=IRoleRepository.findByRole(rolePermissionRequestDTO.getRole());
                //.orElseThrow(() -> new RuntimeException("Role not found with ID: " + rolePermissionRequestDTO.getRole().toString()));

        System.out.println("The permission is"+permission);
        System.out.println("The role is"+role);

        return RolePermission.builder()
                .permission(permission)
                .role(role)
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
