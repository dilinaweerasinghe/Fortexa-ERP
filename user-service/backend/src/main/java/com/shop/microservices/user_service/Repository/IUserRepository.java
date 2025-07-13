package com.shop.microservices.user_service.Repository;

import com.shop.microservices.user_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link User} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations and additional query methods
 * for the {@link User} entity.
 * </p>
 * <p>
 * The {@link Repository} annotation indicates that this interface is a Spring Data repository.
 * </p>
 *
 * @see User The {@link User} entity.
 * @see JpaRepository The {@link JpaRepository} interface providing CRUD operations.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    // Query to fetch the permission based on the given username
    @Query(value = "SELECT  role_permission.id ,user.username,permission.permission FROM RolePermission rp" +
            "JOIN Role r ON rp.role_id = r.role_id" +
            "JOIN UserRole ur ON ur.role_id = r.role_id" +
            "JOIN User u ON u.user_id = ur.user_id" +
            "JOIN Permission p ON rp.permission_id = p.permission_id")
    String findPermissionByUsername(String username);
}
