package com.shop.microservices.user_service.Service.Serviceinterface;

import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Dto.UserResponseDTO;

import java.util.List;

public interface IUserService {

    //add new user
    UserResponseDTO AddNewUser(UserRequestDTO userRequestDTO);

    //get all users
    List<UserResponseDTO> GetAllUser();

    //get user by id
    UserResponseDTO GetUserById(String id);

    //Set user status inactive
    boolean SetUserStatusInactive(String id);

    //Update user details
    UserResponseDTO UpdateUserDetails(String id, UserRequestDTO userRequestDTO);
}
