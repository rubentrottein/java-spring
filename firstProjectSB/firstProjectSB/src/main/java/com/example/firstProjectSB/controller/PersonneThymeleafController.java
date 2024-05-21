package com.example.firstProjectSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.firstProjectSB.model.Personne;
import com.example.firstProjectSB.service.PersonneService;

@Controller
public class PersonneThymeleafController {


	@Autowired
	PersonneService personneService;

	/*@GetMapping("/premierpage")
	public String showFirstPage(Model model) {
		model.addAttribute("premierAttribute", "BONJOUR!");
		return "index2";
	}*/

	@GetMapping("/showListePersonne")
	public String showListePersonne(Model model){
		model.addAttribute("listePersonne", personneService.getAllPersonnes());
		return "displayListePersonne";
	}

	@GetMapping("/getPersonneById")
	public String getPersonneById(@RequestParam(value = "id") Long id,
			Model model) {
		System.out.println(personneService.getPersonneById(id).get());
		model.addAttribute("personneToShow", personneService.getPersonneById(id).get());
		return "displayPersonne";
	}

	@GetMapping("/addPersonne")
	public String addPersonne(Model model, Personne personne) {
		return "addPersonne";
	}


	@PostMapping("/addpersonne")
	public String addpersonne(Personne personne, Model model) {
		personneService.addPersonne(personne);
		model.addAttribute("listePersonne", personneService.getAllPersonnes());
		return "displayListePersonne";
	}

	@GetMapping("updatePersonneById")
	public String showUpdatePersonne(Model model, @RequestParam(value = "id") Long id) {
		model.addAttribute("personneToUpdate", personneService.getPersonneById(id).get());
		return "updatePersonne";
	}

	@PostMapping("/updatePersonne")
	public String updatePersonne(Personne personne, Model model) {
		personneService.update(personne, personne.getId());
		model.addAttribute("listePersonne", personneService.getAllPersonnes());
		return "displayListePersonne";
	}




}
