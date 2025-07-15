package com.shop.microservices.user_service.Repository;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Repository interface for {@link Role} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations and additional query methods
 * for the {@link Role} entity.
 * </p>
 * <p>
 * The {@link Repository} annotation indicates that this interface is a Spring Data repository.
 * </p>
 *
 * @see Role The {@link Role} entity.
 * @see JpaRepository The {@link JpaRepository} interface providing CRUD operations.
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {
    //get the Role When RoleName is given
    Role findByRole(@NotNull(message = "Role must not be null") RoleEnum role);
}