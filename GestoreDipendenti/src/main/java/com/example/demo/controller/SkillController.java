package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SkillService;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
}
