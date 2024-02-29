package com.tienda.model.dto.user;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDto {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;

    public UserDto(String name, String lastName, LocalDate birthDate, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

}
