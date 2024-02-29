package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ruolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tipoRuolo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ruolo")
	private List<Dipendente> listaDipendenti;

	public Ruolo() {
		super();
	}

	public Ruolo(long id, String tipoRuolo, List<Dipendente> listaDipendenti) {
		super();
		this.id = id;
		this.tipoRuolo = tipoRuolo;
		this.listaDipendenti = listaDipendenti;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoRuolo() {
		return tipoRuolo;
	}

	public void setTipoRuolo(String tipoRuolo) {
		this.tipoRuolo = tipoRuolo;
	}

	public List<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}

	public void setListaDipendenti(List<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
}
