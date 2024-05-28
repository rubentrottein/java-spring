package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.model.Transaction;
import com.payme.app.model.User;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
    @Autowired
    private UserService userService;

    @GetMapping("/transactions")
    public String transactions(Model model) {
        User user = userService.getUserByName("user");

        model.addAttribute("transaction", new Transaction());
        model.addAttribute("title", "Transactions");
        model.addAttribute("user", user);
        model.addAttribute("contactList", user.getContactList());
        model.addAttribute("list", user.getTransactionList());
        return "operations";
    }
}
