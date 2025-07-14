package com.shop.microservices.user_service.Dto;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for creating or updating a Role in the system.
 * This DTO contains the necessary information for a Role request, such as role name and role type.
 * Validation annotations ensure that the incoming data meets business requirements.
 */
@Getter
@Setter
@Builder
@Schema(description = "Request DTO for creating or updating a Role.")
public class RoleRequestDTO {

    /**
     * The name of the Role.
     * The role name must not be blank and is required for creating or updating a Role.
     * -- GETTER --
     *  Gets the name of the Role.
     *
     * -- SETTER --
     *  Sets the name of the Role.
     */
    @NotBlank(message = "Role name must not be blank")
    @Schema(description = "The name of the Role", example = "ADMIN")
    private String roleName;

    /**
     * The type of the Role.
     * The role type is required and should be one of the values defined in {@link RoleEnum}.
     * -- GETTER --
     *  Gets the type of the Role.
     *
     * -- SETTER --
     *  Sets the type of the Role.
     */
    @Schema(description = "The type of the Role", example = "ADMIN", allowableValues = {"ADMIN", "OWNER", "SUPER_USER",
            "GENERAL_MANAGER", "PRODUCT_MANAGER", "INVENTORY_MANAGER", "MARKETING_MANAGER", "SALES_MANAGER", "ACCOUNTANT",
            "CASHIER", "LOGISTIC_STAFF", "DATA_ANALYST", "WAREHOUSE_STAFF", "HR_MANAGER", "QA"}, enumAsRef = true, defaultValue = "USER")
    private RoleEnum roleType;

    private String description;
}