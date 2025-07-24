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

import java.time.LocalDateTime;

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
        permissionRequestDTO = new PermissionRequestDTO();
        permissionRequestDTO.setPermission("READ_USER");
        permissionRequestDTO.setDescription("Allows reading user information");

        permissionResponseDTO = PermissionResponseDTO.builder()
                .id("1")
                .permission("READ_USER")
                .description("Allows reading user information")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .createdBy("admin")
                .lastModifiedBy("admin")
                .build();
    }

    @Test
    void testAddPermission() {
        when(permissionService.addPermission(permissionRequestDTO)).thenReturn(permissionResponseDTO);

        ResponseEntity<PermissionResponseDTO> response = permissionController.addPermission(permissionRequestDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("READ_USER", response.getBody().permission());
        assertEquals("Allows reading user information", response.getBody().description());
        assertEquals("1", response.getBody().id());
    }

}
