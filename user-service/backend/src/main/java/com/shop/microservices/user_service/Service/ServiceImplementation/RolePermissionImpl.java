package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Mapper.RolePermissionServiceMapper;
import com.shop.microservices.user_service.Model.RolePermission;
import com.shop.microservices.user_service.Repository.IRolePermissionRepository;
import com.shop.microservices.user_service.Service.Serviceinterface.IRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //Get All Permissions
    @Override
    public List<RolePermissionResponseDTO> getAllPermissionsByRole(){
        List<RolePermission> rolePermissions = iRolePermissionRepository.findAll();
        return rolePermissionServiceMapper.getAllRolePermissions(rolePermissions);
    }

    //Get by Id
    @Override
    public RolePermissionResponseDTO getRolePermissionById(String id){
        RolePermission rolePermission = iRolePermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolePermission not found with ID: " + id));
        return rolePermissionServiceMapper.toDto(rolePermission);
    }

    //Get RolePermission by Role
    @Override
    public List<RolePermissionResponseDTO> getRolePermissionByRole(String role) {
        System.out.println("Role in getRolePermissionByRole: " + role);
        List<RolePermission> rolePermissions = iRolePermissionRepository.findByRole(RoleEnum.valueOf(role));
        return rolePermissionServiceMapper.getAllRolePermissions(rolePermissions);
    }


}
