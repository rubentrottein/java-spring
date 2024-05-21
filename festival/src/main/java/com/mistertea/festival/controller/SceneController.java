package com.mistertea.festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mistertea.festival.service.SceneService;

@Controller
public class SceneController {
	@Autowired
	SceneService service= new SceneService();

}
