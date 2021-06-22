package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<User>> findAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    @GetMapping("/list/name/{name}")
    public ResponseEntity<ArrayList<User>> findByUserNameContains(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByUserNameContains(name));
    }

    @GetMapping("/list/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findUserById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.saveUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/update/{id}/{password}")
    public ResponseEntity<User> updateUserByPass(@PathVariable Long id, @PathVariable String password){
        this.userService.updateUserByPass(id, password);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
