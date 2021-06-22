package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> findAllUsers(){
        return (ArrayList<User>) userRepository.findAllUsers();
    }

    public ArrayList<User> findByUserNameContains(String name){
        return (ArrayList<User>) userRepository.findUserByUserName(name);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }

    public User saveUser(User newUser){
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public void updateUserByPass(Long id, String password) {
        userRepository.updateUserByPass(id, password);
    }
}
