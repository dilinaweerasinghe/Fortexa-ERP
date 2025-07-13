package com.shop.microservices.user_service.Model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a relationship between a {@link User} and a {@link Role}.
 * This entity is used to assign a specific {@link Role} to a {@link User}.
 * It is mapped to the 'user_roles' table in the database and extends the {@link Auditable}
 * class to track auditing fields like createdBy, createdDate, etc.
 * <p>
 * A {@link UserRole} acts as a junction table between the {@link User} and {@link Role} entities.
 * It represents the fact that a {@link User} can have one or more {@link Role}s, and a {@link Role}
 * can be associated with multiple users.
 *
 * @see User        The {@link User} class, which defines the user's details and associated roles.
 * @see Role        The {@link Role} class, which defines the permissions granted to users with that role.
 * @see Auditable   The {@link Auditable} class, which tracks audit information like createdBy, createdDate.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_roles")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole extends Auditable {

    /**
     * Unique identifier for the user role entry.
     * Generated using UUID strategy as the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * The role assigned to the user.
     * This field references the {@link Role} entity.
     */
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    /**
     * The user assigned to the role.
     * This field references the {@link User} entity.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
