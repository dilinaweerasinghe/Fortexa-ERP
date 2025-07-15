package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;

import java.util.List;

public interface IRolePermissionService {

    //Add a new permission to a role
    RolePermissionResponseDTO addPermissionToRole(RolePermissionRequestDTO rolePermissionRequestDTO);

    //Get All Permissions
    List<RolePermissionResponseDTO> getAllPermissionsByRole();
}
