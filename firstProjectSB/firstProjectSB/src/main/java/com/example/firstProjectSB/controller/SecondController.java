package com.example.firstProjectSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstProjectSB.service.SecondService;

@RestController
public class SecondController {

	@Autowired
	SecondService secondService;

	@GetMapping("/numberAdd")
	public int addOne(@RequestParam int number) {
		return secondService.addOne(number);
	}
}
