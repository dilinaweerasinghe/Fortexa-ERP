package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;

public interface IRolePermissionService {

    //Add a new permission to a role
    RolePermissionResponseDTO addPermissionToRole(RolePermissionRequestDTO rolePermissionRequestDTO);
}
