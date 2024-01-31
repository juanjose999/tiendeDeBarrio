package com.tienda.service.user;

import com.tienda.model.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUser(String userId);
    void addUser(User user);
    User update(User user, String userId);
    void deleteUser(String userId);
}
