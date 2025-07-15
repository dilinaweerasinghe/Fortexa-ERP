package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Mapper.PermissionServiceMapper;
import com.shop.microservices.user_service.Model.Permission;
import com.shop.microservices.user_service.Repository.IPermissionRepository;
import com.shop.microservices.user_service.Service.Serviceinterface.IPermissionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private final IPermissionRepository iPermissionRepository;
    private final PermissionServiceMapper permissionMapper;

    public PermissionServiceImpl(IPermissionRepository iPermissionRepository, PermissionServiceMapper permissionMapper) {
        this.iPermissionRepository = iPermissionRepository;
        this.permissionMapper = permissionMapper;
    }

    //Add Permission
    @Override
    public PermissionResponseDTO addPermission(PermissionRequestDTO permissionRequestDTO){
        Permission entity = permissionMapper.toEntity(permissionRequestDTO);
        Permission savedPermission = iPermissionRepository.save(entity);
        return permissionMapper.toDto(savedPermission);
    }

    //Get All Permissions
    @Override
    public List<PermissionResponseDTO> getAllPermissions(){
        List<Permission> permissions = iPermissionRepository.findAll();
        return permissionMapper.toDtoList(permissions);
    }

    //Get Permission by ID
    @Override
    public PermissionResponseDTO getPermissionById(String permissionId){
        Permission permission = iPermissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found with ID: " + permissionId));
        return permissionMapper.toDto(permission);
    }

    //Update Permission
    public PermissionResponseDTO updatePermission(String permissionId, PermissionRequestDTO permissionRequestDTO){
        Permission existingPermission = iPermissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found with ID: " + permissionId));
        // Update fields
        existingPermission.setPermission(permissionRequestDTO.getPermission());
        existingPermission.setDescription(permissionRequestDTO.getDescription());

        Permission updatedPermission = iPermissionRepository.save(existingPermission);
        return permissionMapper.toDto(updatedPermission);
    }
}
