package com.shop.microservices.user_service.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Immutable
@AllArgsConstructor
@Builder
@Setter

public final class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private final String username;
    private final String permission_id;
    private final String permission;

    public UserPermission(String username, String permission_id, String permission){
        this.permission_id=permission_id;
        this.username=username;
        this.permission=permission;
    }
}
