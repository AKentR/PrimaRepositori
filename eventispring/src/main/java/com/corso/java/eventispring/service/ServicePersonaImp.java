package com.corso.java.eventispring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.eventispring.entities.Persona;
import com.corso.java.eventispring.repository.PersonaRepository;

@Service
public class ServicePersonaImp implements ServicePersona {

	@Autowired
	PersonaRepository servicePersonaImp;

	@Override
	public List<Persona> getPersoneInEvento(String nome) {
		List<Persona> lista = new ArrayList<Persona>();
		lista.addAll(servicePersonaImp.selActiveName(nome));
		return lista;
	}

	@Override
	public void createPersona(Persona persona) {
		servicePersonaImp.save(persona);
	}

	@Override
	public void deletePersona(Long idPersona) {
		servicePersonaImp.deleteById(idPersona);
	}

	@Override
	public Optional<Persona> searchPersona(Long idPersona) {
		Optional<Persona> persona= servicePersonaImp.findById(idPersona);
		return persona;
	}

	@Override
	public List<Persona> payType(String metodoPagamento) {
		List<Persona> lista = new ArrayList<Persona>();
		lista.addAll(servicePersonaImp.selActivePayType(metodoPagamento));
		return lista;
	}

	@Override
	public List<Persona> notTotalPay() {
		List<Persona> lista = new ArrayList<Persona>();
		lista.addAll(servicePersonaImp.selActivenotTotalPay());
		return lista;
	}

}
