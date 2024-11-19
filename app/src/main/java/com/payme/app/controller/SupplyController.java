package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.service.SupplyService;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import jakarta.annotation.PostConstruct; // pour jakarta

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplyController {

    @Autowired
    UserService userService;

    @Autowired
    SupplyService supplyService;


    @GetMapping("/supply")
    public String supply(Model model) {
        Supply supply = new Supply();
        User user = userService.getCurrentUser();

        model.addAttribute("title", "Approvisionnement du compte");
        model.addAttribute("supply", supply);
        model.addAttribute("user", user);
        model.addAttribute("contactList", userService.getContactListByUser(user));
        model.addAttribute("supplyList", user.getSupplyList());
        supplyService.addSupply(supply, user.getName());

        return "operations";
    }
}
