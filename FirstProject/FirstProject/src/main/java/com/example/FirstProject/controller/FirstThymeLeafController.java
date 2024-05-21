package com.example.FirstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.service.FirstService;
import com.example.FirstProject.service.PersonService;


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
    @PostMapping("/addUser")
    public String addUser(Person person, BindingResult result, Model model) {
        model.addAttribute("user", person);
        service.addUser(result);
        return "list";
    }

    @GetMapping("/imgSrc")
    public String addUser(Model model) {
        model.addAttribute("img", firstService.addImg(131));
        return "index";
    }
}
