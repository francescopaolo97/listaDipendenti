package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DipendenteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private DipendenteService dipendenteService;
	
	@GetMapping("/effettuaLogin")
	public String effettuaLogin(@RequestParam String email, @RequestParam String password) {
		return dipendenteService.effettuaLogin(email, password);
	}
	
	@PostMapping("/effettuaLogout")
	public String effettuaLogout() {
		return dipendenteService.effettuaLogout();
	}
}
