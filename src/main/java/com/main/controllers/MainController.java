package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.models.Country;
import com.main.models.Url;
import com.main.services.IParsingService;

@Controller
public class MainController {
	
	private static final String JSON_URL = "https://restcountries.eu/rest/v2/name/Burkina";
	
	@Autowired
	private IParsingService parsingService;
	
	
	
	@GetMapping
	public String main(Model model) {
		Url url = new Url();
		List <Country> countries = (List<Country>)parsingService.parse(JSON_URL);
		model.addAttribute("countries", countries);	
		return "index";
	}
	
}
