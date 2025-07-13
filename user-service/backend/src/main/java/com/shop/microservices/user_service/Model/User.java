package com.shop.microservices.user_service.Model;

import com.shop.microservices.user_service.Enumeration.UserStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;

/**
 * Represents a user in the system. A user is associated with a set of roles and personal information.
 * This entity is mapped to the 'user' table in the database, and it extends the {@link Auditable}
 * class to track auditing fields like createdBy, createdDate, etc.
 * <p>
 * A {@link User} defines essential user information such as username, email, password, and status.
 * The user is associated with a set of {@link Role} entities that define the permissions granted to the user.
 *
 * @see Auditable         The {@link Auditable} class, which tracks audit information (e.g., createdBy, createdDate).
 * @see UserStatusEnum    The {@link UserStatusEnum} enum defining possible user statuses (ACTIVE, INACTIVE).
 * @see PersonalInfo      The {@link PersonalInfo} class containing the user's personal details.
 * @see Role              The {@link Role} class defining a set of permissions granted to the user.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class User extends Auditable {

    /**
     * Unique identifier for the user.
     * Generated using UUID strategy as the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * The username associated with the user.
     * This field is unique and required.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * The password for the user.
     * This field is required.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The email address associated with the user.
     * This field is unique and required.
     */
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * The mobile number associated with the user.
     * This field is optional and unique.
     */
    @Column(unique = true)
    private String mobileNo;

    /**
     * The status of the user.
     * This field is required and defaults to {@link UserStatusEnum#ACTIVE}.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatusEnum status = UserStatusEnum.ACTIVE;

    /**
     * Indicates whether two-factor authentication is enabled for the user.
     * This field is required and defaults to false.
     */
    @Column(nullable = false)
    private boolean twoFactorEnabled = false;

    /**
     * Personal information associated with the user.
     * This field is a reference to the {@link PersonalInfo} entity.
     */
    @ManyToOne
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private PersonalInfo personalInfo;

    /**
     * Set of roles associated with this user.
     * Defines the set of permissions granted to the user.
     * A many-to-many relationship between {@link User} and {@link Role}.
     *
     * @see Role The {@link Role} class defining the roles that are granted to the user.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
