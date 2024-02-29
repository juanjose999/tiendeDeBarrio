package com.tienda.service.user;

import com.tienda.model.dto.user.UserDto;
import com.tienda.model.dto.user.UserResponseDto;
import com.tienda.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    Optional<UserResponseDto> findUserById(String id);
    User findByEmail(String email);
    UserResponseDto createUser(UserDto userDto);
    UserResponseDto createUserAdmin(UserDto userDto);

    UserResponseDto saveUser(UserDto userDto);

    Boolean updateUser(String id, UserDto userDto);

    Boolean deleteUserById(String id);
}
