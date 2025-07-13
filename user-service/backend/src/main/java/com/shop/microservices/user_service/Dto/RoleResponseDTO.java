package com.shop.microservices.user_service.Dto;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for responding with Role information.
 * This DTO contains the necessary information for a Role response, such as role name, role type, and audit fields.
 */
@Builder
@Schema(description = "Response DTO for Role information.")
public record RoleResponseDTO(
        @Schema(description = "The unique identifier of the Role", example = "123e4567-e89b-12d3-a456-426614174000")
        String id,

        @Schema(description = "The name of the Role", example = "ADMIN")
        String roleName,

        @Schema(description = "The type of the Role", example = "ADMIN", allowableValues = {"ADMIN", "OWNER", "SUPER_USER",
                "GENERAL_MANAGER", "PRODUCT_MANAGER", "INVENTORY_MANAGER", "MARKETING_MANAGER", "SALES_MANAGER", "ACCOUNTANT",
                "CASHIER", "LOGISTIC_STAFF", "DATA_ANALYST", "WAREHOUSE_STAFF", "HR_MANAGER", "QA"}, enumAsRef = true, defaultValue = "USER")
        RoleEnum roleType,

        @Schema(description = "The date and time when the Role was created", example = "2023-01-01T12:00:00")
        LocalDateTime createdDate,

        @Schema(description = "The date and time when the Role was last modified", example = "2023-01-02T12:00:00")
        LocalDateTime lastModifiedDate,

        @Schema(description = "The user who created the Role", example = "admin")
        String createdBy,

        @Schema(description = "The user who last modified the Role", example = "admin")
        String lastModifiedBy
) {
}