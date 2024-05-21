package com.mistertea.festival.controller;

import jakarta.websocket.OnError;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/error")
    public String onError(Model model, Throwable t) {
        model.addAttribute("error", t);
        model.addAttribute("trace");
        return "error";
    }
}
