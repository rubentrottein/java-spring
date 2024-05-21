package com.mistertea.festival.controller;

import com.mistertea.festival.model.Festival;
import com.mistertea.festival.model.Scene;
import com.mistertea.festival.service.FestivalService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FestivalController {

    private FestivalService service = new FestivalService();

    @GetMapping("/showFestivals")
    public String showFestival(Model model) {

        model.addAttribute("festivalsList", service.getAllFestivals());
        //model.addAttribute("scenesList", service.getScenes(service.getFestivalById(1L)));

        return "index";
    }

    @PostMapping("/createFestival")
    public String createFestival(Festival festival, Model model) {
        service.addFestival(festival);
        model.addAttribute("festival", festival);
        return "index";
    }

    @PostMapping("/addSceneToFestival")
    public List<Scene> addSceneToFestival(@RequestBody Scene scene) {
        return service.addScene(service.getFestivalById(1L), scene);
    }
    @GetMapping("/getScenes")
    public String getScenes(Model model) {
        model.addAttribute("scenes", service.getScenes(service.getFestivalById(1L)));
        return "index";
    }

    @GetMapping("/getFestival")
    public String getFestival(Model model) {
        model.addAttribute("festival", service.getFestivalById(1L));
        return "index";
    }

}
