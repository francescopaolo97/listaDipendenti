package com.example.demo.model;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String email;
	private String password;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "dipendente")
	private List<DipendentiSkill> listaDipendentiSkill;
	
	@ManyToOne
	@JoinColumn(name = "id_ruolo")
	private Ruolo ruolo;

	public Dipendente() {
		super();
	}

	public Dipendente(long id, String username, String email, String password,
			List<DipendentiSkill> listaDipendentiSkill, Ruolo ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.listaDipendentiSkill = listaDipendentiSkill;
		this.ruolo = ruolo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DipendentiSkill> getListaDipendentiSkill() {
		return listaDipendentiSkill;
	}

	public void setListaDipendentiSkill(List<DipendentiSkill> listaDipendentiSkill) {
		this.listaDipendentiSkill = listaDipendentiSkill;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
}
