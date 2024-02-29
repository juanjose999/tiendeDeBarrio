package com.tienda.model.user;
import com.tienda.model.dto.user.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "user")
@Data
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
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
