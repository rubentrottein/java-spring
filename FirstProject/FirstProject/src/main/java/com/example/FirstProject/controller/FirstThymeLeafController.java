package com.example.FirstProject.controller;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FirstThymeLeafController {
    @Autowired
    PersonService service;

    @GetMapping("/index")
    public String showFirstPage(Model model) {
        model.addAttribute("firstAttribute", "Bonjour!");
        return "index";
    }
    @GetMapping("/thymeList")
    public String showThymeList(Model model) {
        model.addAttribute("personsList", service.getPersonListToString());
        return "index";
    }
    @GetMapping("/thymeListLoop")
    public String thymeLoop(Model model) {
        model.addAttribute("persons", service.getPersonList());
        ArrayList<Person> personListToDisplay;
        personListToDisplay = new ArrayList<>(service.getPersonList());
        return personListToDisplay.toString();
    }
    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("list", service.getPersonList());
        return "list";
    }
    @GetMapping("/getUserById")
    public String getUserById(@RequestParam(value="id") Long id, Model model) {
        model.addAttribute("id" ,service.findPerson(id).get().toString());
        return "list";
    }
    @PostMapping("/addUser")
    public String addUser(Person person, BindingResult result, Model model) {
        service.addToList(person);
        return "redirect:/thymeList";
    }
}
