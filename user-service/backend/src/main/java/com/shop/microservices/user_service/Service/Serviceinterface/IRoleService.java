package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;

import java.util.List;

public interface IRoleService {

    // Add a new role to the system
    RoleResponseDTO AddNewRole(RoleRequestDTO roleRequestDTO);

    // Get all roles from the system
     List<RoleResponseDTO> GetAllRoles();

     //Get Role By ID
     RoleResponseDTO GetRoleById(String id);

    String DeleteRoleById(String id);

    RoleResponseDTO UpdateRoleById(String id, RoleRequestDTO roleRequestDTO);

}
