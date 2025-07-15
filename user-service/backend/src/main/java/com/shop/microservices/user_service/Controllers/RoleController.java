package com.shop.microservices.user_service.Controllers;

import com.shop.microservices.user_service.Dto.RoleRequestDTO;
import com.shop.microservices.user_service.Dto.RoleResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IRoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<RoleResponseDTO> addRole(@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO createdRole = iRoleService.AddNewRole(roleRequestDTO);
        return ResponseEntity.ok(createdRole);
    }

    //Get all Roles
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        List<RoleResponseDTO> allRoles = iRoleService.GetAllRoles();
        return ResponseEntity.ok(allRoles);
    }

    //Get Role by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(String id) {
        RoleResponseDTO role = iRoleService.GetRoleById(id);
        return ResponseEntity.ok(role);
    }

    //Delete Role by ID
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoleById(String id) {
        String response = iRoleService.DeleteRoleById(id);
        return ResponseEntity.ok(response);
    }

    //Update Role by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<RoleResponseDTO> updateRoleById(String id, RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO updatedRole = iRoleService.UpdateRoleById(id, roleRequestDTO);
        return ResponseEntity.ok(updatedRole);
    }


}
