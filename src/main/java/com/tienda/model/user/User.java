package com.tienda.model.user;
import com.tienda.model.dto.user.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private LocalDateTime createdUser;
    private String name;
    private String lastName;
    private String email;
    private String password;


    public User(String name, String lastName, String email, String password) {
        this.createdUser = LocalDateTime.now();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public User(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.createdUser = LocalDateTime.now();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(UserDto userDto) {
        this.id = null;
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.password = getPassword();
    }


    public String getId() {
        return id;
    }

    public void setId(String idUser){
        this.id = idUser;
    }

    public LocalDateTime getCreatedUser() {
        return createdUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
