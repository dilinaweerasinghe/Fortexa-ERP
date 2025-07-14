package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;
import com.shop.microservices.user_service.Mapper.RoleServiceMapper;
import com.shop.microservices.user_service.Model.Role;
import com.shop.microservices.user_service.Repository.IRoleRepository;
import com.shop.microservices.user_service.Service.Serviceinterface.IRoleService;
import com.shop.microservices.user_service.Service.Serviceinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements IRoleService {

    @Autowired
    private final IRoleRepository iRoleRepository;
    private final RoleServiceMapper roleServiceMapper;

    public RoleServiceImpl (IRoleRepository iRoleRepository, RoleServiceMapper roleServiceMapper) {
        this.iRoleRepository = iRoleRepository;
        this.roleServiceMapper = roleServiceMapper;
    }

    // Add a new role to the system
    public RoleResponseDTO AddNewRole(RoleRequestDTO roleRequestDTO){
        Role entity = roleServiceMapper.toEntity(roleRequestDTO);
        Role saved = iRoleRepository.save(entity);
        return roleServiceMapper.toDto(saved);
    }

    // Get all roles from the system
    public List<RoleResponseDTO> GetAllRoles(){
        List<Role> roleResponse = iRoleRepository.findAll();
        return roleServiceMapper.GetAllRoles(roleResponse);
    }

    //Get Role By ID
    public RoleResponseDTO GetRoleById(String id) {
        Role role = iRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleServiceMapper.toDto(role);
    }



}
