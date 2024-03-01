package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dipendente;
import com.example.demo.service.AdminService;
import com.example.demo.service.DipendenteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dipendente")
public class DipendenteController {

	@Value("${user}")
	private String USER;
	@Value("${admin}")
	private String ADMIN;

	@Autowired
	private DipendenteService dipendenteService;
	@Autowired
	private AdminService adminService;

	public String isAdminOrUser() {
		return dipendenteService.getDipendenteSessione().getRuolo().getTipoRuolo();
	}
	
	@PostMapping("/inserisciDipendente")
	public String inserisciDipendente(@RequestBody Dipendente dipendente, @RequestParam long idRuolo) {
		return dipendenteService.inserisciDipendente(dipendente, idRuolo);
	}

	@GetMapping("/visualizzaUtenteLoggato")
	public List<?> visualizzaUtenteLoggato() {
		List<String> listaStringhe = new ArrayList<>();
		if(dipendenteService.getDipendenteSessione() == null) {
			listaStringhe.add("Effettua il login");
			return listaStringhe;
		}else {
			return dipendenteService.getDipendenteSessioneNellaLista();
		}
	}

	@GetMapping("/visualizzaListaDipendenti")
	public List<?> visualizzaListaDipendenti(){
		List<String> listaStringhe = new ArrayList<>();
		if(dipendenteService.getDipendenteSessione() == null) {
			listaStringhe.add("Effettua il login");
			return listaStringhe;
		}else {
			if(isAdminOrUser().equals(ADMIN)) {
				return adminService.visualizzaListaDipendenti();
			}else {
				listaStringhe.add("Non hai i permessi da ammministratore");
				return listaStringhe;
			}
		}

	}

	@PutMapping("/inserisciSkillAdUnDipendente")
	public String inserisciSkillAdUnDipendente(@RequestParam long idDipendente, @RequestParam long idSkill, @RequestParam String livello) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}
		else {
			if(isAdminOrUser().equals(ADMIN)) {
				adminService.inserisciSkillAdUnDipendente(idDipendente, idSkill, livello);
				return "Inserimento avvenuto con successo";
			}else {
				return "Non hai i permessi da ammministratore";
			}
		}

	}

	@PutMapping("/inserisciListaSkillAdUnDipendente")
	public String inserisciListaSkillAdUnDipendente(@RequestParam long idDipendente, @RequestParam long[] idSkill, @RequestParam String[] livelli) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}else {
			if(isAdminOrUser().equals(ADMIN)) {
				adminService.inserisciListaSkillAdUnDipendente(idDipendente, idSkill, livelli);
				return "Inserimento avvenuto con successo";
			}else {
				return "Non hai i permessi da ammministratore";
			}
		}
	}

	@PutMapping("/inserisciCompetenze")
	public String inserisciCompetenze(@RequestParam long idSkill, String livello) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}else {
			dipendenteService.inserisciCompetenze(dipendenteService.getDipendenteSessione(), idSkill, livello);
			return "Inserimento avvenuto con successo";
		}
	}
	
	@PutMapping("/modificaAnagrafica")
	public String modificaAnagrafica(@RequestBody Dipendente dipendente) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}else {
			dipendenteService.modificaAnagrafica(dipendenteService.getDipendenteSessione(), dipendente);
			return "Modifica effettuata con successo";
		}
	}
	
	@PatchMapping("/rendiAmministratore")
	public String modificaRuolo(@RequestParam long idDipendente) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}else {
			if(isAdminOrUser().equals(ADMIN)) {
				return adminService.rendiAmministratore(idDipendente);
			}else {
				return "Non hai i permessi da ammministratore";
			}
		}
	}
	
	@GetMapping("/visualizzaPerSkill")
	public List<?> visualizzaPerSkill(@RequestParam long idSkill){
		List<String> listaStringhe = new ArrayList<>();
		if(dipendenteService.getDipendenteSessione() == null) {
			listaStringhe.add("Effettua il login");
			return listaStringhe;
		}else {
			if(isAdminOrUser().equals(ADMIN)) {
				return adminService.visualizzaPerSkill(idSkill);
			}else {
				listaStringhe.add("Non hai i permessi da ammministratore");
				return listaStringhe;
			}
		}
	}
	
	@DeleteMapping("/eliminaUnDipendente")
	public String eliminaUnDipendente(@RequestParam long idDipendente) {
		if(dipendenteService.getDipendenteSessione() == null) {
			return "Effettua il login";
		}else {
			if(isAdminOrUser().equals(ADMIN)) {
				return adminService.eliminaUnDipendente(idDipendente);
			}else {
				return "Non hai i permessi da ammministratore";
			}
		}
	}
}
