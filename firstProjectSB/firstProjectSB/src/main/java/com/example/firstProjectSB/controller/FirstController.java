package com.example.firstProjectSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstProjectSB.model.Personne;
import com.example.firstProjectSB.service.FirstService;

@RestController
public class FirstController {

	@Autowired
	FirstService firstService;

	@GetMapping("/")
	public String serverOn() {
		return "ALIVE!";
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		return "Hello " + firstService.addTruc(name) + "!";
	}

	@PostMapping("/hellos")
	public String sayHellos(@RequestBody Personne personne) {
		return personne.toString();
	}




	/*
	 * creation personneController
	 * 2 endpoints : addPersonne  getAllPersonnes
	 *
	 * creation personneService
	 * dans le service : ajouter list de Personne
	 * addPersonne(Personne personne) ->add to listPersonne
	 * getAllPersonne()
	 *
	 */


}
