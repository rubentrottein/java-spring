package com.mistertea.festival.controller;

import com.mistertea.festival.model.Band;
import com.mistertea.festival.service.BandService;
import com.mistertea.festival.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BandController {
    @Autowired
    BandService bandService = new BandService();
    //SceneService sceneService = new SceneService();

    @GetMapping("/getBands")
    public String displayAllBands(Model model) {
        model.addAttribute("bandsList", bandService.getAllBands());
        model.addAttribute("band", new Band());
       //model.addAttribute("scenesList", sceneService.getAllScenes());
        return "getAllBands";
    }

    @PostMapping("/addBand")
    public String addBand( Band band, Model model){
        model.addAttribute("bandsList", bandService.getAllBands());
        bandService.addBand(band);
        return "getAllBands";
    }

    @GetMapping("/deleteBand")
    public String deleteBand(Model model, Long id){
        bandService.deleteBand(id);
        return "success";
    }
    /* TODO */
    @PutMapping("/updateBand")
    public String updateBand(@RequestParam Long id, @PathVariable Band band){
        bandService.updateBand(id, band);
        return "/addBand";
    }
}
