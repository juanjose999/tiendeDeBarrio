package com.tienda.repository.user.mongodb;

import com.tienda.model.user.User;
import com.tienda.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMongoRespotory userMongoRespotory;

    @Override
    public List<User> getAllUsers() {
        return userMongoRespotory.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userMongoRespotory.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        return userMongoRespotory.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userFound = userMongoRespotory.findByEmail(email);
        if (userFound.isPresent()){
            return userFound;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public User saveUser(User user) {
        return userMongoRespotory.save(user);
    }

    @Override
    public Boolean updateUser(String id, User user) {
        User foundUser = findUserById(id);
        if(foundUser != null){
            foundUser.setName(user.getName());
            foundUser.setLastName(user.getLastName());
            foundUser.setEmail(user.getEmail());
            foundUser.setPassword(user.getPassword());

            userMongoRespotory.save(foundUser);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserById(String id) {
        User userExist = findUserById(id);
        if(userExist != null){
            userMongoRespotory.delete(userExist);
            return true;
        }
        return false;
    }
}
