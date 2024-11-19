package com.payme.app.controller;

import com.payme.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("msg", "Opération effectuée");
        return "confirmation";
    }

    @GetMapping("/error")
    public String onError(Model model, Throwable t) {
        model.addAttribute("msg", t);
        model.addAttribute("trace");
        return "confirmation";
    }
}
