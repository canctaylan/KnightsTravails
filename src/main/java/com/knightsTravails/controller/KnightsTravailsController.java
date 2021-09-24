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
		return knightsTravailsService.findShortestDistance(start, end);
	}

}
