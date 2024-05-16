package com.example.FirstProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	
	@PostMapping("/addPerson")
	public String addPerson(@RequestBody Person user){
		String newList = service.addToList(user);
		return newList;
	}
	
	@PostMapping("/getList")
	public ArrayList<Person> getList(){
		return service.getPersonList();
	}
	@PostMapping("/getAllPerson")
	public String getAllPerson(){
		return service.getPersonListToString();
	}
	@PostMapping("/getPerson")
	public String getPerson(@RequestBody Person user){
		
		return  "<h3>" + user.getFirstName() 
		+ " " + user.getLastName() + "</h3>"
		+ "<i>" + user.getBirthDate() + "</i>, " + user.getAge() + "ans.";
	}
}