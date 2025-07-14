package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;

public interface IRoleService {
    RoleRequestDTO AddNewRole(RoleResponseDTO roleResponseDTO);
}
