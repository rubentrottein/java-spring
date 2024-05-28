package com.payme.app.service;

import com.payme.app.model.User;
import com.payme.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String name){
        return userRepository.getUserByName(name);
    }

    public List<User> getContactListByUser(User user) {
        return userRepository.findContactListByName(user.getName());
    }
}
