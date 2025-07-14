package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;
import com.shop.microservices.user_service.Mapper.RoleServiceMapper;
import com.shop.microservices.user_service.Model.Role;
import com.shop.microservices.user_service.Repository.IRoleRepository;
import com.shop.microservices.user_service.Service.Serviceinterface.IRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional

public class RoleServiceImpl implements IRoleService {

    @Autowired
    private final IRoleRepository iRoleRepository;
    private final RoleServiceMapper roleServiceMapper;

    public RoleServiceImpl (IRoleRepository iRoleRepository, RoleServiceMapper roleServiceMapper) {
        this.iRoleRepository = iRoleRepository;
        this.roleServiceMapper = roleServiceMapper;
    }

    // Add a new role to the system
    @Override
    public RoleResponseDTO AddNewRole(RoleRequestDTO roleRequestDTO){
        Role entity = roleServiceMapper.toEntity(roleRequestDTO);
        Role saved = iRoleRepository.save(entity);
        return roleServiceMapper.toDto(saved);
    }

    // Get all roles from the system
    @Override
    public List<RoleResponseDTO> GetAllRoles(){
        List<Role> roleResponse = iRoleRepository.findAll();
        return roleServiceMapper.GetAllRoles(roleResponse);
    }

    //Get Role By ID
    @Override
    public RoleResponseDTO GetRoleById(String id) {
        Role role = iRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleServiceMapper.toDto(role);
    }

    //Delete Role By ID
    @Override
    public String DeleteRoleById(String id) {
        Role role = iRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        iRoleRepository.delete(role);
        return id;
    }

    //Update Role By ID
    @Override
    public RoleResponseDTO UpdateRoleById(String id, RoleRequestDTO roleRequestDTO) {
        Role existingRole = iRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        existingRole.setRole(roleRequestDTO.getRoleType());
        existingRole.setDescription(roleRequestDTO.getDescription());
        Role updatedRole = iRoleRepository.save(existingRole);
        return roleServiceMapper.toDto(updatedRole);
    }

}
