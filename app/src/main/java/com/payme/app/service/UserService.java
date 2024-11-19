package com.payme.app.service;

import com.payme.app.model.User;
import com.payme.app.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        encodeAllPasswords(); // Encode tous les mots de passe non encodés dans la base
    }


    public void encodeAllPasswords() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (!user.getPassword().startsWith("$2a$")) { // Vérifie si le mot de passe n'est pas déjà encodé
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
            }
        }
    }

    public List<User> getContactListByUser(User user) {
        return userRepository.findContactListByName(user.getName());
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof org.springframework.security.core.userdetails.User userDetails) {
            return userRepository.getUserByName(userDetails.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found in database"));
        }

        throw new UsernameNotFoundException("User not authenticated");
    }


    public User getUserByName(String name) {
        return userRepository.getUserByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void registerNewUserAccount(User user) {
        // Vérifiez si l'utilisateur existe déjà
        if (userRepository.findByName(user.getName()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Encodez le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

}