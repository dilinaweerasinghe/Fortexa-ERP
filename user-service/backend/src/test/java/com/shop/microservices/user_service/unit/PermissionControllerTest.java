package com.shop.microservices.user_service.unit;

import com.shop.microservices.user_service.Controllers.PermissionController;
import com.shop.microservices.user_service.Dto.PermissionRequestDTO;
import com.shop.microservices.user_service.Dto.PermissionResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IPermissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PermissionControllerTest {

    @Mock
    private IPermissionService permissionService;

    @InjectMocks
    private PermissionController permissionController;

    private PermissionRequestDTO permissionRequestDTO;
    private PermissionResponseDTO permissionResponseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        permissionRequestDTO = new PermissionRequestDTO();
        permissionRequestDTO.setPermission("READ_USER");

//        permissionResponseDTO = new PermissionResponseDTO();
//        permissionResponseDTO.setId("1");
//        permissionResponseDTO.setDescription("Permission to read user data");
    }

    @Test
    void testAddPermission() {
        when(permissionService.addPermission(permissionRequestDTO)).thenReturn(permissionResponseDTO);

        ResponseEntity<PermissionResponseDTO> response = permissionController.addPermission(permissionRequestDTO);

        assertEquals(200, response.getStatusCodeValue());
        //assertEquals("READ_USER", response.getBody().getName());
    }

}
