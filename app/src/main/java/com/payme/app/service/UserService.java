package com.payme.app.service;

import com.payme.app.model.User;
import com.payme.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User userByName(String name){
        return userRepository.getUserByName(name);
    }
}
