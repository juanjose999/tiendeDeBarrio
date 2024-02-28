package com.tienda.service.user;

import com.tienda.model.dto.user.UserDto;
import com.tienda.model.dto.user.UserMapper;
import com.tienda.model.dto.user.UserResponseDto;
import com.tienda.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtos.add(UserMapper.user_To_UserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public Optional<UserResponseDto> findUserById(String id) {
        UserResponseDto user = UserMapper.user_To_UserResponseDto(userRepository.findUserById(id));
        return Optional.ofNullable(user);
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return UserMapper.user_To_UserResponseDto(userRepository.saveUser(UserMapper.userDto_To_User(userDto)));
    }

    @Override
    public Boolean updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, UserMapper.userDto_To_User(userDto));
    }

    @Override
    public Boolean deleteUserById(String id) {
        return userRepository.deleteUserById(id);
    }
}
