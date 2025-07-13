package com.shop.microservices.user_service.Service.ServiceImplementation;

import com.shop.microservices.user_service.Dto.UserRequestDTO;
import com.shop.microservices.user_service.Dto.UserResponseDTO;
import com.shop.microservices.user_service.Enumeration.UserStatusEnum;
import com.shop.microservices.user_service.Model.User;
import com.shop.microservices.user_service.Repository.IUserRepository;
import com.shop.microservices.user_service.Mapper.UserServiceMapper;
import com.shop.microservices.user_service.Service.Serviceinterface.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private final UserServiceMapper userServiceMapper;
    private final IUserRepository iUserRepository;

    public UserServiceImpl(UserServiceMapper userServiceMapper, IUserRepository iUserRepository){
        this.userServiceMapper = userServiceMapper;
        this.iUserRepository = iUserRepository;
    }

    //Add a new user to the system
    @Override
    public UserResponseDTO AddNewUser(UserRequestDTO userRequestDTO){
        User entity=userServiceMapper.toEntity(userRequestDTO);
        User saved =iUserRepository.save(entity);
        return userServiceMapper.toDto(saved);
    }

    //Get All Users from the system
    @Override
    public List<UserResponseDTO> GetAllUser(){
        List<User> userResponse=iUserRepository.findAll();
        return userServiceMapper.GetAllUser(userResponse);
    }

    //Get User by Id from the system
    @Override
    public  UserResponseDTO GetUserById(String id){
        User user = iUserRepository.findById(id).orElse(null);
        if (user != null) {
            return userServiceMapper.toDto(user);
        }
        return null;
    }

    //Set User Status Inactive
    @Override
    public boolean SetUserStatusInactive(String id){
        User user = iUserRepository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(UserStatusEnum.INACTIVE);
            iUserRepository.save(user);
            return true;
        }
        return false;
    }

    //Update user details (Only email and mobile number)
    @Override
    public UserResponseDTO UpdateUserDetails(String id, UserRequestDTO userRequestDTO){
        User user = iUserRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(userRequestDTO.getEmail());
            user.setMobileNo(userRequestDTO.getMobileNo());
            User updatedUser = iUserRepository.save(user);
            return userServiceMapper.toDto(updatedUser);
        }
        return null;
    }

    //get the Permission type based on the user id

}

