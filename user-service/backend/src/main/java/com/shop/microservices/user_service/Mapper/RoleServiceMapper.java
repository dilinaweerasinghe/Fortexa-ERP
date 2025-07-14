package com.shop.microservices.user_service.Mapper;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;
import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.Role;
import com.shop.microservices.user_service.Model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleServiceMapper {

    //Map the RoleRequestDTO to the Entity (Save)
    public Role toEntity(RoleRequestDTO roleRequestDTO){
        if(roleRequestDTO ==null){
            return null;
        }

        if (roleRequestDTO.getRoleType() == null) {
            System.err.println("Warning: roleType in RoleRequestDTO is null. Defaulting to USER.");
        }

        return Role.builder()
                .role(RoleEnum.valueOf(roleRequestDTO.getRoleType().toString()))
                .description(roleRequestDTO.getDescription())
                .build();
    }


    //Map the Role to the RoleResponseDTO (Fetch)
    public RoleResponseDTO toDto(Role role){
        if(role ==null){
            return null;
        }
        return RoleResponseDTO.builder()
                .id(role.getId())
                .roleName(role.getDescription())
                .roleType(role.getRole())
                .createdDate(LocalDateTime.ofInstant(role.getCreatedDate(), ZoneId.systemDefault()))
                .lastModifiedDate(LocalDateTime.ofInstant(role.getLastModifiedDate(), ZoneId.systemDefault()))
                .createdBy(role.getCreatedBy())
                .lastModifiedBy(role.getLastModifiedBy())
                .build();
    }

    //map All the Roles to the DTO
    public List<RoleResponseDTO> GetAllRoles(List<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
