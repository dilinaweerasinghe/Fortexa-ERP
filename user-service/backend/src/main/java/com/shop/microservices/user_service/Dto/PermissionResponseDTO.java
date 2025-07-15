package com.shop.microservices.user_service.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for responding with Permission information.
 * This DTO contains the necessary information for a Permission response, such as permission name, description, and audit fields.
 */
@Schema(description = "Response DTO for Permission information.")
@Builder
public record PermissionResponseDTO(
        @Schema(description = "The unique identifier of the Permission", example = "123e4567-e89b-12d3-a456-426614174000")
        String id,

        @Schema(description = "The permission name or code", example = "READ_USER")
        String permission,

        @Schema(description = "A detailed description of the permission", example = "Allows reading user information")
        String description,

        @Schema(description = "The date and time when the Permission was created", example = "2023-01-01T12:00:00")
        LocalDateTime createdDate,

        @Schema(description = "The date and time when the Permission was last modified", example = "2023-01-02T12:00:00")
        LocalDateTime lastModifiedDate,

        @Schema(description = "The user who created the Permission", example = "admin")
        String createdBy,

        @Schema(description = "The user who last modified the Permission", example = "admin")
        String lastModifiedBy
) {
}