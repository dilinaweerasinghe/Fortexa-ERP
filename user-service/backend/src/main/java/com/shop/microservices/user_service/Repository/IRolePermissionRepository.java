package com.shop.microservices.user_service.Repository;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Repository interface for {@link RolePermission} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations and additional query methods
 * for the {@link RolePermission} entity.
 * </p>
 * <p>
 * The {@link Repository} annotation indicates that this interface is a Spring Data repository.
 * </p>
 *
 * @see RolePermission The {@link RolePermission} entity.
 * @see JpaRepository The {@link JpaRepository} interface providing CRUD operations.
 */
@Repository
public interface IRolePermissionRepository extends JpaRepository<RolePermission, String> {
    // Additional query methods can be defined here
    List<RolePermission> findByRole(@NotNull(message = "Role must not be null") RoleEnum role);
}