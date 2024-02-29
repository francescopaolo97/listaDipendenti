package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dipendente;
import com.example.demo.model.Skill;
import com.example.demo.service.DipendenteService;

@RestController
@RequestMapping("/api/dipendente")
public class DipendenteController {
	
	@Value("${user}")
	private String USER;
	@Value("${admin}")
	private String ADMIN;

	@Autowired
	private DipendenteService dipendenteService;
	
	public String isAdminOrUser() {
		return dipendenteService.getDipendenteSessione().getRuolo().getTipoRuolo();
	}
	
	@GetMapping("/visualizzaUtenteLoggato")
	public Dipendente visualizzaUtenteLoggato() {
		return dipendenteService.getDipendenteSessione();
	}
	
	@GetMapping("/visualizzaListaDipendenti")
	public List<?> visualizzaListaDipendenti(){
		List<String> listaStringhe = new ArrayList<>();
		if(isAdminOrUser().equals(ADMIN)) {
			return dipendenteService.visualizzaListaDipendenti();
		}else {
			listaStringhe.add("Non hai i permessi da ammministratore");
			return listaStringhe;
		}
	}
	
	@PutMapping("/inserisciSkillAdUnDipendente")
	public void inserisciSkillAdUnDipendente(@RequestParam long idDipendente, @RequestParam long idSkill, @RequestParam String livello) {
		if(isAdminOrUser().equals(ADMIN)) {
			dipendenteService.inserisciSkillAdUnDipendente(idDipendente, idSkill, livello);
		}
	}
	
	@PutMapping("/inserisciListaSkillAdUnDipendente")
	public void inserisciListaSkillAdUnDipendente(@RequestParam long idDipendente, @RequestParam long[] idSkill, @RequestParam String[] livelli) {
		if(isAdminOrUser().equals(ADMIN)) {
			dipendenteService.inserisciListaSkillAdUnDipendente(idDipendente, idSkill, livelli);
		}
	}
}
