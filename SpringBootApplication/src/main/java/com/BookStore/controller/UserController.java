package com.BookStore.controller;

import com.BookStore.dto.UserRequestDTO;
import com.BookStore.dto.UserResponseDTO;
import com.BookStore.entity.User;
import com.BookStore.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<User>> ListUserById(@PathVariable Integer id){
        UserResponseDTO users=  this.userService.getAllUserById(id);
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> ListAllUser(){
        List<UserResponseDTO> users=  this.userService.getAllUser();
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRequestDTO u){
        User user=  this.userService.saveUser(u);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Boolean DeleteUserById(@PathVariable Integer id){
        Boolean isDeleted=  this.userService.deleteUserById(id);
        return isDeleted;
    }
}
