package com.shop.microservices.user_service.Controllers;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IRolePermissionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role-permissions")
public class RolePermissionController {
    private final IRolePermissionService rolePermissionService;

    public RolePermissionController(IRolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    //Add a new permission to a role
    @PostMapping
    public ResponseEntity<RolePermissionResponseDTO> addPermissionToRole(@Valid @RequestBody RolePermissionRequestDTO rolePermissionRequestDTO) {
        RolePermissionResponseDTO response = rolePermissionService.addPermissionToRole(rolePermissionRequestDTO);
        return ResponseEntity.ok(response);
    }

    //Get All Permissions by Role
    @GetMapping
    public ResponseEntity<List<RolePermissionResponseDTO>> getAllPermissionsByRole() {
        List<RolePermissionResponseDTO> response = rolePermissionService.getAllPermissionsByRole();
        return ResponseEntity.ok(response);
    }

}
