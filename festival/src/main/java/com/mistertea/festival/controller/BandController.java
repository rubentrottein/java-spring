package com.mistertea.festival.controller;

import com.mistertea.festival.model.Band;
import com.mistertea.festival.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
@Controller
public class BandController {
    @Autowired
    BandService service = new BandService();

    @GetMapping("/getBands")
    public String displayAllBands(Model model) {
        model.addAttribute("bandsList", service.getAllBands());
        return "getAllBands";
    }
    @PostMapping("/addBand")
    public String addBand(@RequestBody Band band, Model model){
        model.addAttribute("band", band);
        service.addBand(band);
        return "getAllBands";
    }
}
