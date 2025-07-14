package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IPermissionService;

import java.util.List;

public class PermissionServiceImpl implements IPermissionService {

    //Add Permission
    @Override
    public PermissionRequestDTO addPermission(PermissionRequestDTO permissionRequestDTO){
        return null;
    }

    //Get All Permissions
    @Override
    public List<PermissionResponseDTO> getAllPermissions(){
        return null;
    }

    //Get Permission by ID
    @Override
    public PermissionResponseDTO getPermissionById(String permissionId){
        return null;
    }

    //Update Permission
    public PermissionResponseDTO updatePermission(String permissionId, PermissionRequestDTO permissionRequestDTO){
        return null;
    }
}
