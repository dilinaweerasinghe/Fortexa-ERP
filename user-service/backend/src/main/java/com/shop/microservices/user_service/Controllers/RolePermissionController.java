package com.shop.microservices.user_service.Controllers;

import com.shop.microservices.user_service.Dto.RolePermissionRequestDTO;
import com.shop.microservices.user_service.Dto.RolePermissionResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IRolePermissionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
