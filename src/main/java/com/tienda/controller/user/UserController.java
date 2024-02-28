package com.tienda.controller.user;
import com.tienda.model.dto.user.UserDto;
import com.tienda.model.dto.user.UserResponseDto;
import com.tienda.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        try {
            List<UserResponseDto> users = userService.getAllUsers();
            System.out.println("Number of user response DTOs: " + users.size());
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            System.err.println("Error in getAllUser controller: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserResponseDto>> findUserById(@PathVariable  String userId){
        try{
            return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + userId + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String userId, @RequestBody UserDto userDto){
        try{
            Boolean isUpdateUser = userService.updateUser(userId, userDto);
            if(isUpdateUser){
                return new ResponseEntity("the user update is ok." , HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + userId + " doesn't in the data base." , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }
}
