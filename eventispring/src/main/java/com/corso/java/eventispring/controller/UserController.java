package com.corso.java.eventispring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.eventispring.entities.Evento;
import com.corso.java.eventispring.entities.Persona;
import com.corso.java.eventispring.service.ServiceEvento;
import com.corso.java.eventispring.service.ServicePersona;

@RestController
@RequestMapping("/events")
public class UserController {

	@Autowired
	ServicePersona servicePersonaImp;

	@Autowired
	ServiceEvento serviceEventoImp;

	@GetMapping("/printallevents")
	public List<Evento> getAllEvents() {
		return serviceEventoImp.getAllEvento();
	}

	@PostMapping("/createEvento")
	public void creaE(@RequestBody Evento evento) {
		serviceEventoImp.createEvento(evento);
	}

	@RequestMapping(value = "/deleteEvento/{idEvento}", method = RequestMethod.DELETE)
	public void cancE(@PathVariable Long idEvento) {
		serviceEventoImp.deleteEvento(idEvento);
	}

	@GetMapping("/printOneEvent/{idEvento}")
	public Optional<Evento> getOneEvent(@PathVariable Long idEvento) {
		return serviceEventoImp.searchEvento(idEvento);
	}

	@GetMapping("/durataENumero/{durataEvento}/{posti}")
	public ResponseEntity<List<Evento>> getEventDuration(@PathVariable int durataEvento, @PathVariable int posti) {
		List<Evento> lista = (List<Evento>) serviceEventoImp.controlDateNumber(durataEvento, posti);
		if (lista == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Evento>>(lista, HttpStatus.OK);
	}

	@GetMapping("/eventoInRed/{luogoEvento}")
	public ResponseEntity<List<Evento>> getEventInRed(@PathVariable String luogoEvento) {
		List<Evento> lista = (List<Evento>) serviceEventoImp.EventoInred(luogoEvento);
		if (lista == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Evento>>(lista, HttpStatus.OK);
	}

	@GetMapping("/printListPersoneE/{nomeEvento}")
	public ResponseEntity<List<Persona>> getAllQuery(@PathVariable("nomeEvento") String nomeEvento) {
		List<Persona> lista = (List<Persona>) servicePersonaImp.getPersoneInEvento(nomeEvento);
		if (lista == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@PostMapping("/createPersona")
	public void creaP(@RequestBody Persona persona) {
		servicePersonaImp.createPersona(persona);
	}

	@RequestMapping(value = "/deletePersona/{idPersona}", method = RequestMethod.DELETE)
	public void cancP(@PathVariable Long idPersona) {
		servicePersonaImp.deletePersona(idPersona);
	}

	@GetMapping("/printOnePersona/{idPersona}")
	public Optional<Persona> getOnePersona(@PathVariable Long idPersona) {
		return servicePersonaImp.searchPersona(idPersona);
	}

	@GetMapping("/payTipe/{metodoPagamento}")
	public ResponseEntity<List<Persona>> getMetodoPaga(@PathVariable("metodoPagamento") String metodoPagamento) {
		List<Persona> lista = (List<Persona>) servicePersonaImp.payType(metodoPagamento);
		if (lista == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/personeCheNonPagano")
	public ResponseEntity<List<Persona>> getPersoneIllegali() {
		List<Persona> lista = (List<Persona>) servicePersonaImp.notTotalPay();
		if (lista == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}
}
