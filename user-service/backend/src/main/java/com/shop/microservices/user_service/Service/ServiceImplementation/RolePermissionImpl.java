package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Mapper.RolePermissionServiceMapper;
import com.shop.microservices.user_service.Model.RolePermission;
import com.shop.microservices.user_service.Repository.IRolePermissionRepository;
import com.shop.microservices.user_service.Service.Serviceinterface.IRolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionImpl implements IRolePermissionService {

    private final RolePermissionServiceMapper rolePermissionServiceMapper;
    private final IRolePermissionRepository iRolePermissionRepository;

    public RolePermissionImpl(RolePermissionServiceMapper rolePermissionServiceMapper, IRolePermissionRepository iRolePermissionRepository) {
        this.rolePermissionServiceMapper = rolePermissionServiceMapper;
        this.iRolePermissionRepository = iRolePermissionRepository;
    }

    //Add a new permission to a role
    @Override
    public RolePermissionResponseDTO addPermissionToRole(RolePermissionRequestDTO rolePermissionRequestDTO){
        RolePermission entity = rolePermissionServiceMapper.toEntity(rolePermissionRequestDTO);
        if (entity != null) {
            RolePermission saved = iRolePermissionRepository.save(entity);
            return rolePermissionServiceMapper.toDto(saved);
        }
        return null;
    }


}
