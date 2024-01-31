package com.tienda.service.user;

import com.tienda.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserServiceImplement implements UserService {
    private HashMap<String, User> userMap;
    @Autowired
    public UserServiceImplement(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }

    @Override
    public User findUser(String userId) {
        if(userMap.containsKey(userId)){
            return userMap.get(userId);
        }else {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String idNewUser = user.getId();
        userMap.put(idNewUser, user);
    }

    @Override
    public User update(User user, String userId) {
        if(!userMap.containsKey(userId)){
            throw  new RuntimeException("USUARIO NO ENCONTRADO.");
        }
        User existingUser = userMap.get(userId);

        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        //existingUser.setPassword(user.getPassword());

        userMap.put(userId,existingUser);
        return existingUser;

    }

    @Override
    public void deleteUser(String userId) {
        userMap.remove(userId);
    }
}
