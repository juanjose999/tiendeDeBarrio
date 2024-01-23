package com.tienda.service;

import com.tienda.model.User;

import java.util.List;

public interface UserCrudService {
    void addUser(List<User> userServices);
    void deleteUser(List<User> userServices);
    void allUser(List<User> userServices);
    void editUsers(List<User> userServices);
    void findUsers(List<User> userServices);
    void findUserById(List<User> userServices);
}
