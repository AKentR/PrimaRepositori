package com.corso.java.eventispring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

@Table(name = "eventi")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evento")
	private Long idEvento;
	private String nomeEvento;
	private String luogoEvento;
	private int durataEvento;
	private double costoUnitario;
	private double costoTotale;
	private int posti;

	public Evento() {

	}

	public Evento(String nomeEvento, String luogoEvento, int durataEvento, double costoUnitario, double costoTotale,
			int posti) {
		this.nomeEvento = nomeEvento;
		this.luogoEvento = luogoEvento;
		this.durataEvento = durataEvento;
		this.posti = posti;
		this.costoUnitario = costoUnitario;
		this.costoTotale = costoTotale;
	}

	public Evento(Long idEvento, String nomeEvento, String luogoEvento, int durataEvento, double costoUnitario,
			double costoTotale, int posti) {
		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.luogoEvento = luogoEvento;
		this.durataEvento = durataEvento;
		this.posti = posti;
		this.costoUnitario = costoUnitario;
		this.costoTotale = costoTotale;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getLuogoEvento() {
		return luogoEvento;
	}

	public void setLuogoEvento(String luogoEvento) {
		this.luogoEvento = luogoEvento;
	}

	public int getdurataEvento() {
		return durataEvento;
	}

	public void setdurataEvento(int durataEvento) {
		this.durataEvento = durataEvento;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nomeEvento=" + nomeEvento + ", luogoEvento=" + luogoEvento
				+ ", durataEvento=" + durataEvento + ", posti=" + posti + ", costoUnitario=" + costoUnitario
				+ ", costoTotale=" + costoTotale + "]";
	}
}
