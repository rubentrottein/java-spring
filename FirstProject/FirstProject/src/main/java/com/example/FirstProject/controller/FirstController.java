package com.example.FirstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstProject.service.FirstService;

@RestController
public class FirstController {
	String name = "Ruben";

	@Autowired
	FirstService service;

	@GetMapping("/")
	public String welcome(){
		return service.style() + "<header style='background: black; color: seagreen; font-family: 'Arial'; font-weight: 100'>"
				+ "<h1>Site Java Spring !</h1>"
				+ "<nav style='display:flex; justify-content: space-around; width: 50%;'>"
				+ "<a href='/hello?name=" + name + ">Poursuivre en tant que " + name + "</a> "
				+ "<a href='/addUser'>addPerson</a>"
				+ "<a href='/list'>getAllPerson</a>"
				+ "<a href='/index'>About</a>"
				+"</nav></header>";
	}
	@GetMapping("/hello")
	public String action(@RequestParam String name){
		return "<h1>Hello World!</h1>"
				+ "<p><i>Bienvenue " + name + "</i></p>"
				+ service.addTo("Un Canapé!")
				+ service.addImg(151)
				+ "<a href='/'>Retour à l'accueil</a>";
	}
}
