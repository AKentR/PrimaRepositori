package com.corso.java.eventispring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.eventispring.entities.Evento;
import com.corso.java.eventispring.repository.EventoRepository;

@Service
public class ServiceEventoImp implements ServiceEvento {

	@Autowired
	EventoRepository serviceEventoImp;

	@Override
	public void createEvento(Evento evento) {
		serviceEventoImp.save(evento);

	}

	@Override
	public void deleteEvento(Long idEvento) {
		serviceEventoImp.deleteById(idEvento);
	}

	@Override
	public List<Evento> getAllEvento() {
		return serviceEventoImp.findAll();
	}

	@Override
	public Optional<Evento> searchEvento(Long idEvento) {
		Optional<Evento> evento = serviceEventoImp.findById(idEvento);
		return evento;

	}

	@Override
	public List<Evento> controlDateNumber(int giorni, int numero) {
		List<Evento> lista = new ArrayList<Evento>();
		lista.addAll(serviceEventoImp.selActiveNumber(giorni, numero));
		return lista;
	}

	@Override
	public List<Evento> EventoInred(String luogoEvento) {
		List<Evento> lista = new ArrayList<Evento>();
		lista.addAll(serviceEventoImp.selActivePlace(luogoEvento));
		return lista;
	}
}
