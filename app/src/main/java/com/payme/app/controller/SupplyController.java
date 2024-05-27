package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.service.SupplyService;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplyController {
    SupplyService supplyService = new SupplyService();

    @GetMapping("/supplies")
    public String supplies(Model model) {
        model.addAttribute("supplies", supplyService.getSupplyListByUserName("user"));
        model.addAttribute("title", "Approvisionnement du compte");
        return "operations";
    }
}
