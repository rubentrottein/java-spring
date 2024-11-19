package com.example.FirstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.service.FirstService;
import com.example.FirstProject.service.PersonService;

import java.time.LocalDate;


@Controller
public class FirstThymeLeafController {
    @Autowired
    PersonService service;

    @Autowired
    FirstService firstService;

    @GetMapping("/index")
    public String showFirstPage(Model model) {
        model.addAttribute("firstAttribute", "Bienvenue!");
        return "index";
    }
    @GetMapping("/thymeList")
    public String showThymeList(Model model) {
        model.addAttribute("personsList", service.getPersonListToString());
        return "index";
    }
    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("list", service.getPersonList());
        return "list";
    }
    @GetMapping("/getUserById")
    public String getUserById(@RequestParam(value="id") Long id, Model model) {
        //model.addAttribute("id" ,service.findPerson(id).get().toString());
        model.addAttribute("id" ,service.findPerson(id).get());
        return "list";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new Person()); // Initialiser un objet pour le formulaire
        return "addUser"; // Retourne le nom du template
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Person person, Model model) {
        service.addPerson(person); // Appel du service pour traiter les données
        model.addAttribute("user", person);
        return "list"; // Rediriger vers une page de confirmation ou autre
    }

    @PostMapping("/updateUser")
    public String updateUser(Person person, Model model) {
        model.addAttribute("userToUpdate", person);
        service.updatePerson(person.getId(), person);
        return "updateUser";
    }

    @GetMapping("/imgSrc")
    public String chgImgSource(Model model) {
        model.addAttribute("img", firstService.addImg(131));
        return "index";
    }
}
