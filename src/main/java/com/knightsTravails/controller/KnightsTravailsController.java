package com.knightsTravails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.knightsTravails.service.KnightsTravailsService;

@RestController
@RequestMapping("/knightsTravails")
public class KnightsTravailsController {

	@Autowired
	private KnightsTravailsService knightsTravailsService;

	@GetMapping(value = "/api")
	@ResponseBody
	public String getShortestPath(@RequestParam String start, @RequestParam String end) {
		if (start.isBlank() || end.isBlank())
			return "Null input parameter(s)";
		else if(start.equals(end))
			return "Start and locations are the same. Please enter different locations";
		else if(!start.matches("[A-H][1-8]") || !end.matches("[A-H][1-8]"))
			return "Invalid input parameter formats. Please enter inputs with a capital letter and a number. Ex: C3";
		
		return knightsTravailsService.findShortestPath(start, end);
	}

}
