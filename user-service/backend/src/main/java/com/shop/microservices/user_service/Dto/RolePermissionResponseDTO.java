package com.shop.microservices.user_service.Dto;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for responding with Role-Permission information.
 * This DTO contains the necessary information for a Role-Permission response, such as ID, permission ID, role, and audit fields.
 */
@Builder
@Schema(description = "Response DTO for Role-Permission information.")
public record RolePermissionResponseDTO(
        @Schema(description = "The unique identifier of the Role-Permission association", example = "123e4567-e89b-12d3-a456-426614174000")
        String id,

        @Schema(description = "The ID of the Permission", example = "123e4567-e89b-12d3-a456-426614174000")
        String permissionId,

        @Schema(description = "The role included in the RoleEnum", example = "ADMIN", allowableValues = {"ADMIN", "OWNER",
                "SUPER_USER", "GENERAL_MANAGER", "PRODUCT_MANAGER", "INVENTORY_MANAGER", "MARKETING_MANAGER", "SALES_MANAGER",
                "ACCOUNTANT", "CASHIER", "LOGISTIC_STAFF", "DATA_ANALYST", "WAREHOUSE_STAFF", "HR_MANAGER", "QA"}, enumAsRef = true)
        RoleEnum role,

        @Schema(description = "The date and time when the Role-Permission association was created", example = "2023-01-01T12:00:00")
        LocalDateTime createdDate,

        @Schema(description = "The date and time when the Role-Permission association was last modified", example = "2023-01-02T12:00:00")
        LocalDateTime lastModifiedDate,

        @Schema(description = "The user who created the Role-Permission association", example = "admin")
        String createdBy,

        @Schema(description = "The user who last modified the Role-Permission association", example = "admin")
        String lastModifiedBy
) {
}