package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.service.SupplyService;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SupplyService supplyService;

    @GetMapping("/profile")
    public String profile(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByName(userName);

        model.addAttribute("title", "Profil de l'utilisateur");
        model.addAttribute("username", userName);
        model.addAttribute("user", user);

        user.setSupplyList(supplyService.getSupplyListByUserName(userName));

        if (user.getContactList().isEmpty()) {
            model.addAttribute("contactsList","Liste des contacts");
        } else {
            model.addAttribute
            ("contactsList", user.getContactList());
        }
        if (user.getTransactionList().isEmpty()) {
            model.addAttribute("transactionList","Liste des Transactions");
        } else {
            model.addAttribute("transactionList", user.getTransactionList());
        }
        if (user.getSupplyList().isEmpty()) {
            model.addAttribute("supplyList","Liste des Approvisionnements");
        } else {
            model.addAttribute("supplyList", user.getSupplyList());
        }
        return "profile";
    }
}
