package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RuoloService;

@RestController
@RequestMapping("/api/ruolo")
public class RuoloController {

	@Autowired
	private RuoloService ruoloService;
}
