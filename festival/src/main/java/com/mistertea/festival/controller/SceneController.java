package com.mistertea.festival.controller;

import com.mistertea.festival.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mistertea.festival.service.SceneService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SceneController {
	@Autowired
	SceneService service = new SceneService();

	@GetMapping("/getScenes")
	public String displayAllScenes(Model model) {
		model.addAttribute("scenes", service.getAllScenes());
		return "getAllScenes";
	}

	@PostMapping("/addScene")
	public String addScene(@RequestBody Scene scene, Model model) {
		model.addAttribute("scene", scene);
		service.addScene(scene);
		return "getAllScenes";
	}

}
