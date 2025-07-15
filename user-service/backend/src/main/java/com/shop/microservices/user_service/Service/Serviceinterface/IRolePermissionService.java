package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Enumeration.RoleEnum;

import java.util.List;

public interface IRolePermissionService {

    //Add a new permission to a role
    RolePermissionResponseDTO addPermissionToRole(RolePermissionRequestDTO rolePermissionRequestDTO);

    //Get All Permissions
    List<RolePermissionResponseDTO> getAllPermissionsByRole();

    //Get by Id
    RolePermissionResponseDTO getRolePermissionById(String id);

    //Get RolePermission by Role
    List<RolePermissionResponseDTO> getRolePermissionByRole(String role);
}
