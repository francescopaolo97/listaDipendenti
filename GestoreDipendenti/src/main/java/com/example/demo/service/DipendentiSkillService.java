package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DipendentiSkillRepository;

@Service
public class DipendentiSkillService {

	@Autowired
	private DipendentiSkillRepository dipendentiSkillRepository;
}
