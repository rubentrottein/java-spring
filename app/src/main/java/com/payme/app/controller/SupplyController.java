package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.service.SupplyService;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplyController {
    @Autowired
    UserService userService;

    @Autowired
    SupplyService supplyService;

    User user = userService.getUserByName("user");

    @GetMapping("/supplies")
    public String supplies(Model model) {
        model.addAttribute("list", supplyService.getSupplyListByUserName("user"));
        model.addAttribute("title", "Approvisionnement du compte");
        return "operations";
    }

    @GetMapping("/supply")
    public String supply(Model model) {
        Supply supply = new Supply();
        model.addAttribute("supply", supply);
        /*

        try{
            model.addAttribute("contactList", userService.getContactListByUser(user));
        } catch (Throwable t){
            model.addAttribute("contactList", "erreur dans l'obtention de la liste de contacts");
        }

         */
        model.addAttribute("supplyList", user.getSupplyList());
        supplyService.addSupply(supply);

        return "operations";
    }
}
