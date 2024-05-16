package com.example.FirstProject.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService {
	public String addTo(String s) {
		return "<div>Le camion contient " + s + "</div>";
	}
	public String addImg(int imageNb) {
		return "<img src='https://picsum.photos/id/"+imageNb+"/1980/500' style='max-width: 100%'>";
	}
	public String style() {
		return "<style>"
				+ "*{margin: 0; box-sizing:border-box; font-family: 'Trebuchet Sans MS'; text-decoration:none;}"
				+ "a{color: gold;"
				+ "</style>";
	}
}
