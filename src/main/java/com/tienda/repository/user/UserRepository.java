package com.tienda.repository.user;

import com.tienda.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    User findUserById(String id);

    User saveUser(User user);

    Boolean updateUser(String id, User user);

    Boolean deleteUserById(String id);
}
