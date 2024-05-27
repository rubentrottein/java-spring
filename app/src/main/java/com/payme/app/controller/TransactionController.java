package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
    @GetMapping("/transactions")
    public String transactions(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("title", "Transactions");
        return "operations";
    }

}
