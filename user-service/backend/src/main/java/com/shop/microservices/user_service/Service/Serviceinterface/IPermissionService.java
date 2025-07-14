package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import java.util.List;

public interface IPermissionService {
    //Add Permission
    PermissionRequestDTO addPermission(PermissionRequestDTO permissionRequestDTO);

    //Get All Permissions
    List<PermissionResponseDTO> getAllPermissions();

    //Get Permission by ID
    PermissionResponseDTO getPermissionById(String permissionId);

    //Update Permission
    PermissionResponseDTO updatePermission(String permissionId, PermissionRequestDTO permissionRequestDTO);



}
