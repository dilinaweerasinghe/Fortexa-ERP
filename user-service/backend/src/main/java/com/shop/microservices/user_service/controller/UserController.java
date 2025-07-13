package com.shop.microservices.user_service.controller;

import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Dto.UserResponseDTO;
import com.shop.microservices.user_service.Service.Serviceinterface.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/user")
public class UserController {
    private final IUserService iUserService;

    public UserController (IUserService iUserService){
        this.iUserService = iUserService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO > AddNewUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO createUser = iUserService.AddNewUser(userRequestDTO);
        return  ResponseEntity.ok(createUser);
    }
}

