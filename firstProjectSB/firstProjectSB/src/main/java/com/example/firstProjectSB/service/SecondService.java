package com.example.firstProjectSB.service;

import org.springframework.stereotype.Service;

@Service
public class SecondService {


	public int addOne(int i) {
		return ++i;
	}
}
