package com.society.management.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ValidationController {

	
	@GetMapping("/loginForm")
	public String getLogInForm(@RequestParam String param) {
		return "form";
	}
	
}
