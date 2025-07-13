package com.shop.microservices.user_service.Dto;

import com.shop.microservices.user_service.Enumeration.UserStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springdoc.api.annotations.ParameterObject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for creating or updating a User in the system.
 * This DTO contains the necessary information for a User request, such as username, password, email, mobile number, status, and two-factor authentication.
 * Validation annotations ensure that the incoming data meets business requirements.
 */
@Getter
@Setter
@Builder
@ParameterObject
@Schema(description = "Request DTO for creating or updating a User.")
public class UserRequestDTO {

    /**
     * The username of the User.
     * The username must not be blank and is required for creating or updating a User.
     * -- GETTER --
     *  Gets the username of the User.
     *
     * -- SETTER --
     *  Sets the username of the User.
     */
    @NotBlank(message = "Username must not be blank")
    @Schema(description = "The username of the User", example = "john_doe")
    private String username;

    /**
     * The password for the User.
     * -- GETTER --
     *  Gets the password of the User.
     *
     * -- SETTER --
     *  Sets the password of the User.
     */
    @NotBlank(message = "Password must not be blank")
    @Schema(description = "The password of the User",  example = "password123")
    private String password;

    /**
     * The email address of the User.
     * The email must be valid and is required for creating or updating a User.
     * -- GETTER --
     *  Gets the email of the User.
     *
     * -- SETTER --
     *  Sets the email of the User.
     */
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    @Schema(description = "The email address of the User",  example = "john.doe@example.com")
    private String email;

    /**
     * The mobile number of the User.
     * The mobile number is optional but should be a string.
     * -- GETTER --
     *  Gets the mobile number of the User.
     *
     * -- SETTER --
     *  Sets the mobile number of the User.
     */
    @Schema(description = "The mobile number of the User",  example = "+1234567890")
    private String mobileNo;

    /**
     * The status of the User.
     * The status is required and should be one of the values defined in {@link UserStatusEnum}.
     * -- GETTER --
     *  Gets the status of the User.
     *
     * -- SETTER --
     *  Sets the status of the User.
     */
    @Schema(description = "The status of the User", example = "ACTIVE", allowableValues = {"ACTIVE", "INACTIVE"}, enumAsRef = true, defaultValue = "ACTIVE")
    private UserStatusEnum status;

    /**
     * Indicates whether two-factor authentication is enabled for the User.
     * This field is required and defaults to false.
     * -- GETTER --
     *  Gets the two-factor authentication status of the User.
     *
     * -- SETTER --
     *  Sets the two-factor authentication status of the User.
     */
    @Schema(description = "Indicates whether two-factor authentication is enabled for the User", allowableValues = {"true", "false"}, defaultValue = "false", example = "false")
    private boolean twoFactorEnabled;
}