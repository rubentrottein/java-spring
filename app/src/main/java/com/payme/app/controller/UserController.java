package com.payme.app.controller;

import com.payme.app.model.User;
import com.payme.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    private final UserService userService;
    //TODO Effacer l'User de démo
    User demoUser = new User("Name", 100, "IBAN", "login@gmail.com", "password", new ArrayList<>(), new ArrayList<>());

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = userService.userByName("user");
        model.addAttribute("user", user);

        /* TODO Listes*
        if (demoUser.getContactList() == null) {
            model.addAttribute("contactsList","Liste des contacts");
        } else {
            model.addAttribute("contactsList", user.getContactList().toString());
        }
        if (demoUser.getTransactionList() == null) {
            model.addAttribute("transactionList","Liste des Transaction");
        } else {
            model.addAttribute("TransactionList", user.getTransactionList().toString());
        }
        */
        
        return "profile";
    }
}
