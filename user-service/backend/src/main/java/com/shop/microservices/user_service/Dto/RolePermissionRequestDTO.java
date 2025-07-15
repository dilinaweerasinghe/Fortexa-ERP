package com.shop.microservices.user_service.Dto;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for creating or updating Role-Permission associations.
 * This DTO contains the necessary information for a Role-Permission request, such as permission ID and role.
 */
@Getter
@Setter
@Builder
@Schema(description = "Request DTO for creating or updating Role-Permission associations.")
public class RolePermissionRequestDTO {

    /**
     * The ID of the Permission.
     * The permission ID must not be blank and is required for creating or updating a Role-Permission association.
     * -- GETTER --
     *  Gets the ID of the Permission.
     *
     * -- SETTER --
     *  Sets the ID of the Permission.
     */
    @NotBlank(message = "Permission ID must not be blank")
    @Schema(description = "The ID of the Permission", example = "123e4567-e89b-12d3-a456-426614174000")
    private String permissionId;

    /**
     * The role included in the RoleEnum.
     * The role must not be null and is required for creating or updating a Role-Permission association.
     * -- GETTER --
     *  Gets the role.
     *
     * -- SETTER --
     *  Sets the role.
     */
    @NotNull(message = "Role must not be null")
    @Schema(description = "The role included in the RoleEnum", example = "ADMIN", allowableValues = {"ADMIN", "OWNER",
            "SUPER_USER", "GENERAL_MANAGER", "PRODUCT_MANAGER", "INVENTORY_MANAGER", "MARKETING_MANAGER", "SALES_MANAGER",
            "ACCOUNTANT", "CASHIER", "LOGISTIC_STAFF", "DATA_ANALYST", "WAREHOUSE_STAFF", "HR_MANAGER", "QA"}, enumAsRef = true)
    private RoleEnum role;
}