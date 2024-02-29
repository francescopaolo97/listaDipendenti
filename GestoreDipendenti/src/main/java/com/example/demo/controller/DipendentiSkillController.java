package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DipendentiSkillService;

@RestController
@RequestMapping("/api/dipendentiSkill")
public class DipendentiSkillController {

	@Autowired
	private DipendentiSkillService dipendentiSkillService;
}
