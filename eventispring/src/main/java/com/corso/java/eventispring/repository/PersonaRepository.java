package com.corso.java.eventispring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.eventispring.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	@Query(nativeQuery = true, value = "SELECT persone.* FROM persone JOIN eventi WHERE persone.id_evento=eventi.id_evento AND eventi.nome_evento=?1")
	List<Persona> selActiveName(String nome);
	@Query(nativeQuery = true, value = "SELECT persone.* FROM persone WHERE persone.metodo_di_pagamento=?1")
	List<Persona> selActivePayType(String metodoPagamento);
	@Query(nativeQuery = true, value = "SELECT persone.* FROM persone,eventi WHERE persone.id_evento=eventi.id_evento AND persone.importo_versato<eventi.costo_unitario")
	List<Persona> selActivenotTotalPay();
	
}
