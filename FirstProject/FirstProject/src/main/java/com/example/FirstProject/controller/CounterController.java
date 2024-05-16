package com.example.FirstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstProject.service.AccountingService;

@RestController
public class CounterController {
	
	@Autowired
	AccountingService service;
	
	@GetMapping("/counter")
	public String count(@RequestParam int chiffre) {
		return "<h1>Service Comptabilité</h1>"
		+ "<p><i>Votre chiffre à gagné 1. Il passe de " + chiffre + " à " + service.counter(chiffre) + "</i></p>"
				+ "<a href='/'>Retour à l'accueil</a>";
	}
}
