package com.shop.microservices.user_service.Mapper;

import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Dto.UserResponseDTO;
import com.shop.microservices.user_service.Enumeration.UserStatusEnum;
import com.shop.microservices.user_service.Model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceMapper {

    //Map the UserRequestDTO to the Entity
    public User toEntity(UserRequestDTO userRequestDTO){
        if(userRequestDTO ==null){
            return null;
        }
        return User.builder()
                .username(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .email(userRequestDTO.getEmail())
                .mobileNo(userRequestDTO.getMobileNo())
                .status(userRequestDTO.getStatus())
                .twoFactorEnabled(userRequestDTO.isTwoFactorEnabled())
                .build();
    }

    //Map the User to the UserResponseDTO
    public UserResponseDTO toDto(User user){
        if(user ==null){
            return null;
        }
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .mobileNo(user.getMobileNo())
                .status(user.getStatus())
                .twoFactorEnabled(user.isTwoFactorEnabled())
                .createdDate(LocalDateTime.ofInstant(user.getCreatedDate(), ZoneId.systemDefault()))
                .lastModifiedDate(LocalDateTime.ofInstant(user.getLastModifiedDate(), ZoneId.systemDefault()))
                .lastModifiedBy(String.valueOf(user.getLastModifiedDate()))
                .createdBy(user.getCreatedBy()).build();
    }

    //map all the users to the DTO
    public List<UserResponseDTO> GetAllUser(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
