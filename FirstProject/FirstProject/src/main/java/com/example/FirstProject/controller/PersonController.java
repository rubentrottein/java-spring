package com.example.FirstProject.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.example.FirstProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
    @Autowired
    private PersonRepository personRepository;

	@PostMapping("/addPerson")
	public StringBuilder addPerson(@RequestBody Person user){
		return service.addToList(user);
	}

	@PutMapping("/updatePerson/{id}")
	public String updatePerson(@PathVariable Long id , @RequestBody Person user){
		if(service.updatePerson(id, user) != null){
			return service.updatePerson(id, user).toString();
		} else {
			return "Update error";
		}
	}
	
	@PostMapping("/getList")
	public ArrayList<Person> getList(){
		return service.getPersonList();
	}
	@PostMapping("/getAllPerson")
	public StringBuilder getAllPerson(){
		service.getPersonList();
		return service.getPersonListToString();
	}
	@PostMapping("/getPerson")
	public String getPerson(@RequestBody Person user){
		
		return  "<h3>" + user.getFirstName() 
		+ " " + user.getLastName() + "</h3>"
		+ "<i>" + user.getBirthDate() + "</i>, " + user.getAge() + "ans.";
	}

	@GetMapping("/findPerson")
	public Optional<Person> findPerson(@RequestParam Long id) {

		Optional<Person> person = service.findPerson(id);
		return person;
	}

	@DeleteMapping("/deletePerson")
	public String deletePersonById(@RequestParam Long id) {
		service.deletePerson(id);
		return "Suppression";
	}
}