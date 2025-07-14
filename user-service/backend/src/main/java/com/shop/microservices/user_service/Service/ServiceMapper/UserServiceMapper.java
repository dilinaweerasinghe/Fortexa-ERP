package com.shop.microservices.user_service.Service.ServiceMapper;

import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Dto.UserResponseDTO;
import com.shop.microservices.user_service.Enumeration.UserStatusEnum;
import com.shop.microservices.user_service.Model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserServiceMapper {

    //Map the UserRequestDTO to the Entity
    public User toEntity(UserRequestDTO userRequestDTO){
        if(userRequestDTO ==null){
            return null;
        }
        return
                User.builder()
                .username(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .email(userRequestDTO.getEmail())
                .mobileNo(userRequestDTO.getMobileNo())
                .status(userRequestDTO.getStatus())
                .twoFactorEnabled(userRequestDTO.isTwoFactorEnabled())
                .build();
    }

    //Map the User to the UserResponseDTO
    public UserResponseDTO ToDto(User user){
        if(user ==null){
            return null;
        }
         return UserResponseDTO.builder()
                 .email(user.getEmail())
                 .mobileNo(user.getMobileNo())
                 .status(user.getStatus())
                 .twoFactorEnabled(user.isTwoFactorEnabled())
                 .createdDate(LocalDateTime.from(user.getCreatedDate()))
                 .lastModifiedBy(String.valueOf(user.getLastModifiedDate()))
                 .createdBy(user.getCreatedBy())
                 .lastModifiedBy(user.getLastModifiedBy()).build();
    }
}
