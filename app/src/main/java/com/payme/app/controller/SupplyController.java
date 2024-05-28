package com.payme.app.controller;

import com.payme.app.model.Supply;
import com.payme.app.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SupplyController {
    @Autowired
    SupplyService supplyService = new SupplyService();

    @GetMapping("/supplies")
    public String supplies(Model model) {
        model.addAttribute("list", supplyService.getSupplyListByUserName("user"));
        model.addAttribute("title", "Approvisionnement du compte");
        return "operations";
    }

    @PostMapping("/supply")
    public String supply(Model model) {
        Supply supply = new Supply();
        model.addAttribute("supply", supply);
        supplyService.addSupply(supply);

        return "operations";
    }
}
