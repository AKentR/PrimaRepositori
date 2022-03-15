package com.corso.java.eventispring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persone")
public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Long idPersona;
	
	@Column(name = "nome_persona")
	private String nome;
	
	@Column(name = "cognome_persona")
	private String cognome;
	
	@Column(name = "affiliazione")
	private String affiliazione;
	
	@Column(name = "metodo_di_pagamento")
	private String metodoPagamento;
	
	@Column(name = "importo_versato")
	private double importo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Evento", referencedColumnName = "id_Evento")
	private Evento idEvento;

	public Persona() {

	}

	public Persona(String nome, String cognome, String affiliazione, String metodoPagamento, double importo,
			Evento idEvento) {
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
		this.metodoPagamento = metodoPagamento;
		this.importo = importo;
		this.idEvento = idEvento;
	}

	public Persona(Long idPersona, String nome, String cognome, String affiliazione, String metodoPagamento,
			double importo, Evento idEvento) {
		this.idPersona = idPersona;
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
		this.metodoPagamento = metodoPagamento;
		this.importo = importo;
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getAffiliazione() {
		return affiliazione;
	}

	public void setAffiliazione(String affiliazione) {
		this.affiliazione = affiliazione;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", affiliazione=" + affiliazione
				+ ", metodoPagamento=" + metodoPagamento + ", importo=" + importo + ", idEvento=" + idEvento
				+ ", idPersona=" + idPersona + "]";
	}
}
