package com.shop.microservices.user_service.Model;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Represents a role in the system. A role defines a set of permissions that a user can have.
 * This entity is mapped to the 'role' table in the database, and it extends the {@link Auditable}
 * class to track auditing fields like createdBy, createdDate, etc.
 * <p>
 * A {@link Role} associates a set of permissions to a user, helping manage user access
 * to various system actions.
 *
 * @see Auditable     The {@link Auditable} class, which tracks the audit information (e.g., creation and modification dates).
 * @see RoleEnum      The {@link RoleEnum} enumeration, which defines a set of predefined roles (e.g., ADMIN, OWNER).
 * @see Permission    The {@link Permission} entity, which defines the actions users can perform in the system.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends Auditable {

    /**
     * Unique identifier for the role.
     * Generated using UUID strategy as the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * The role associated with the permission set.
     * This field uses the {@link RoleEnum} to define predefined roles like ADMIN, OWNER, etc.
     *
     * @see RoleEnum The {@link RoleEnum} enum defining the available roles in the system.
     */
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    /**
     * A description providing more details about the role.
     * This field is optional and can be used for additional information about the role.
     */
    private String description;

    /**
     * Set of permissions associated with this role.
     * Defines the permissions granted to a user who has this role.
     * A many-to-many relationship between {@link Role} and {@link Permission}.
     *
     * @see Permission The {@link Permission} entity defining specific actions granted by the role.
     */
    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
