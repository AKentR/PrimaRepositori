package com.corso.java.eventispring.service;

import java.util.List;
import java.util.Optional;

import com.corso.java.eventispring.entities.Evento;

public interface ServiceEvento {

	public void createEvento(Evento evento);

	public void deleteEvento(Long idEvento);

	public List<Evento> getAllEvento();

	public Optional<Evento> searchEvento(Long idEvento);

	public List<Evento> controlDateNumber(int giorni, int numero);

	public List<Evento> EventoInred(String luogoEvento);
}
