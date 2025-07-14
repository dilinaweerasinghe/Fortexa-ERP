package com.shop.microservices.user_service.Controllers;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/roles")
public class RoleController {

    private final IRoleService iRoleService;

    public RoleController(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    //Add a Role
    @PostMapping
    public ResponseEntity<RoleResponseDTO> addRole(RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO createdRole = iRoleService.AddNewRole(roleRequestDTO);
        return ResponseEntity.ok(createdRole);
    }

    //Get all Roles
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        List<RoleResponseDTO> allRoles = iRoleService.GetAllRoles();
        return ResponseEntity.ok(allRoles);
    }


}
