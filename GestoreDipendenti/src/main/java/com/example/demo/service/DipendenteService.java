package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChiaveComposta;
import com.example.demo.model.Dipendente;
import com.example.demo.model.DipendentiSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.DipendenteRepository;
import com.example.demo.repository.DipendentiSkillRepository;
import com.example.demo.repository.SkillRepository;

@Service
public class DipendenteService {

	@Autowired
	private DipendenteRepository dipendenteRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private DipendentiSkillRepository dipendentiSkillRepository;

	private Dipendente dipendenteSessione;


	public Dipendente getDipendenteSessione() {
		return dipendenteSessione;
	}

	public void setDipendenteSessione(Dipendente dipendenteSessione) {
		this.dipendenteSessione = dipendenteSessione;
	}
	
	public String effettuaLogin(String email, String password) {
		Dipendente d = dipendenteRepository.findByEmailAndPassword(email, password);
		if(d != null) {
			setDipendenteSessione(d);
			return "Accesso eseguito. Benvenuto " + getDipendenteSessione().getUsername();	
		}
		else {
			setDipendenteSessione(null);
			return "Accesso negato, credenziali non valide! Riprova.";
		}
	}

	public List<Dipendente> visualizzaListaDipendenti() {
		return dipendenteRepository.findAll();
	}

	public void inserisciSkillAdUnDipendente(long idDipendente, long idSkill, String livello) {
		Dipendente dipendente = dipendenteRepository.getReferenceById(idDipendente);
		Skill skill = skillRepository.getReferenceById(idSkill);
		DipendentiSkill dipendentiSkill = new DipendentiSkill();
		ChiaveComposta key = new ChiaveComposta();
		key.setIdDipendente(idDipendente);
		key.setIdSkill(idSkill);
		dipendentiSkill.setDipendente(dipendente);
		dipendentiSkill.setId(key);
		dipendentiSkill.setSkill(skill);
		dipendentiSkill.setLivello(livello);
		dipendentiSkillRepository.save(dipendentiSkill);
//		dipendente.getListaDipendentiSkill().add(dipendentiSkill);
//		skill.getListaDipendentiSkill().add(dipendentiSkill);
//		dipendenteRepository.save(dipendente);
//		skillRepository.save(skill);
	
	}
}