package com.corso.java.eventispring.service;

import java.util.List;
import java.util.Optional;

import com.corso.java.eventispring.entities.Persona;

public interface ServicePersona {

	public void createPersona(Persona persona);

	public void deletePersona(Long idPersona);

	public Optional<Persona> searchPersona(Long idPersona);

	public List<Persona> payType(String metodoPagamento );

	public List<Persona> notTotalPay();

	public List<Persona> getPersoneInEvento(String nome);
}
