package com.payme.app.controller;

import com.payme.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    //TODO Effacer l'User de démo
    User demoUser = new User("Name", 100, "IBAN", "login@gmail.com", "password", new ArrayList<>(), new ArrayList<>());

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", demoUser);

        if (demoUser.getContactList() == null) {
            model.addAttribute("contactsList","Liste des contacts");
        } else {
            model.addAttribute("contactsList", demoUser.getContactList().toString());
        }
        if (demoUser.getTransactionList() == null) {
            model.addAttribute("transactionList","Liste des Transaction");
        } else {
            model.addAttribute("TransactionList", demoUser.getTransactionList().toString());
        }
        return "profile";
    }
}
