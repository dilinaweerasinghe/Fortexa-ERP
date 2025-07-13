package com.shop.microservices.user_service.Model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents the association between roles and permissions in the system.
 * This entity maps to the 'role_permissions' table and links a specific role to a specific permission.
 * It also includes auditing information inherited from the {@link Auditable} class.
 *
 * @see Role       The {@link Role} entity representing user roles in the system.
 * @see Permission The {@link Permission} entity representing the actions a user can perform.
 * @see Auditable  The {@link Auditable} class providing audit information.
 */
@Entity
@Table(name = "role_permissions")
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermission extends Auditable {

    /**
     * Unique identifier for the role-permission association.
     * Generated using UUID strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * The role associated with this permission.
     * This represents the role to which the permission is granted.
     *
     * @see Role The {@link Role} entity.
     */
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    /**
     * The permission associated with this role.
     * This represents the specific permission granted to the role.
     *
     * @see Permission The {@link Permission} entity.
     */
    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    private Permission permission;
}
