package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChiaveComposta;
import com.example.demo.model.Dipendente;
import com.example.demo.model.DipendentiSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.DipendenteRepository;
import com.example.demo.repository.DipendentiSkillRepository;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.repository.SkillRepository;

@Service
public class DipendenteService {

	@Autowired
	private DipendenteRepository dipendenteRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private DipendentiSkillRepository dipendentiSkillRepository;
	@Autowired
	private RuoloRepository ruoloRepository;

	@Value("${user}")
	private String USER;
	@Value("{admin}")
	private String ADMIN;

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

	public List<Dipendente> getDipendenteSessioneNellaLista() {
		List<Dipendente> lista = new ArrayList<>();
		lista.add(getDipendenteSessione());
		return lista;
	}

	public void inserisciCompetenze(Dipendente dipendenteSessioneNow, long idSkill, String livello) {
		DipendentiSkill ds = new DipendentiSkill();
		ChiaveComposta key = new ChiaveComposta();
		Skill skill = skillRepository.getReferenceById(idSkill);
		key.setIdDipendente(dipendenteSessioneNow.getId());
		key.setIdSkill(idSkill);
		ds.setDipendente(dipendenteSessioneNow);
		ds.setLivello(livello);
		ds.setSkill(skill);
		ds.setId(key);
		dipendentiSkillRepository.save(ds);
		dipendenteSessioneNow.getListaDipendentiSkill().add(ds);
		dipendenteRepository.save(dipendenteSessioneNow);
	}

	public void modificaAnagrafica(Dipendente dipendenteSessioneNow, Dipendente dipendente) {
		dipendenteSessioneNow.setEmail(dipendente.getEmail());
		dipendenteSessioneNow.setPassword(dipendente.getPassword());
		dipendenteSessioneNow.setUsername(dipendente.getUsername());
		dipendenteRepository.save(dipendenteSessioneNow);
	}

	public String inserisciDipendente(Dipendente dipendente, long idRuolo) {
		dipendente.setRuolo(ruoloRepository.getReferenceById(idRuolo));
		//dipendente.setPassword(PasswordUtils.hashPassword(dipendente.getPassword()));
		dipendenteRepository.save(dipendente);
		return dipendente.getUsername() + " è stato aggiunto correttamente al Database";
	}

	public String effettuaLogout() {
		if(getDipendenteSessione() == null) {
			return "Nessun dipendente è attualmente loggato. Effettua il login per accedere alle vari funzionalità";
		}else {
			setDipendenteSessione(null);
			return "Logout effettuato con successo. Effettua nuovamente il login per accedere alle vari funzionalità";
		}

	}
}
