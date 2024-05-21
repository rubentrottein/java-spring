package com.mistertea.festival.controller;

import com.mistertea.festival.model.Festival;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FestivalController {
    @GetMapping("/showFestival")
    public String showFestival(Model model) {
        model.addAttribute("festival", new Festival());
        return "index";
    }
}
