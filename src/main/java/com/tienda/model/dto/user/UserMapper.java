package com.tienda.model.dto.user;

import com.tienda.model.user.User;

public class UserMapper {

    public static UserResponseDto user_To_UserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User userDto_To_User (UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

}
