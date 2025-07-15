package com.shop.microservices.user_service.Repository;

import com.shop.microservices.user_service.Enumeration.RoleEnum;
import com.shop.microservices.user_service.Model.Permission;
import com.shop.microservices.user_service.Model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Permission} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations and additional query methods
 * for the {@link Permission} entity.
 * </p>
 * <p>
 * The {@link Repository} annotation indicates that this interface is a Spring Data repository.
 * </p>
 *
 * @see Permission The {@link Permission} entity.
 * @see JpaRepository The {@link JpaRepository} interface providing CRUD operations.
 */
 @Repository
 public interface IPermissionRepository extends JpaRepository<Permission, String> {
 }
