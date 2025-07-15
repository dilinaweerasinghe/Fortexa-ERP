package com.shop.microservices.user_service.Controllers;

import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IPermissionService;
import com.shop.microservices.user_service.Service.Serviceinterface.IRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/permissions")
public class PermissionController {

    private final IPermissionService IPermissionService;

    public PermissionController(IPermissionService IPermissionService) {
        this.IPermissionService = IPermissionService;
    }

    //Add a Permission
    @PostMapping
    public ResponseEntity<PermissionResponseDTO> addPermission(@RequestBody PermissionRequestDTO permissionRequestDTO) {
        PermissionResponseDTO createdPermission = IPermissionService.addPermission(permissionRequestDTO);
        return ResponseEntity.ok(createdPermission);
    }

    // Get all Permissions
    @GetMapping
    public ResponseEntity<List<PermissionResponseDTO>> getAllPermissions() {
        List<PermissionResponseDTO> allPermissions = IPermissionService.getAllPermissions();
        return ResponseEntity.ok(allPermissions);
    }

    // Get Permission by ID
    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> getPermissionById(@PathVariable String id) {
        PermissionResponseDTO permission = IPermissionService.getPermissionById(id);
        return ResponseEntity.ok(permission);
    }

    // Update Permission
    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> updatePermission(
            @PathVariable String id,
            @RequestBody PermissionRequestDTO permissionRequestDTO) {
        PermissionResponseDTO updatedPermission = IPermissionService.updatePermission(id, permissionRequestDTO);
        return ResponseEntity.ok(updatedPermission);
    }


}
