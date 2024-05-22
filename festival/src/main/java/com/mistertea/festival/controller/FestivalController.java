package com.mistertea.festival.controller;

import com.mistertea.festival.model.Festival;
import com.mistertea.festival.model.Scene;
import com.mistertea.festival.service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FestivalController {

    @Autowired
    private FestivalService service;

    @GetMapping("/getFestivals")
    public String getFestivals(Model model) {

        model.addAttribute("festivalsList", service.getAllFestivals());
        //model.addAttribute("scenesList", service.getScenes(service.getFestivalById(1L)));

        return "index";
    }

    @PostMapping("/addFestival")
    public String addFestival(@RequestBody Festival festival, Model model) {
        model.addAttribute("festival", festival);
        service.addFestival(festival);
        return "index";
    }
    /*
    @PostMapping("/addSceneToFestival")
    public List<Scene> addSceneToFestival(@RequestBody Scene scene) {
        return service.addScene(service.getFestivalById(1L), scene);
    }
    @GetMapping("/getFestivalsScenes")
    public String getScenes(Model model) {
        model.addAttribute("scenes", service.getFestivalScenes(service.getFestivalById(1L)));
        return "index";
    }

    @GetMapping("/getOneFestival")
    public String getOneFestival(Model model) {
        model.addAttribute("principalFestival", service.getFestivalById(1L));
        return "index";
    }
    **/

}
