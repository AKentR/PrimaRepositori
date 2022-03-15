package com.corso.java.eventispring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.eventispring.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	@Query(nativeQuery = true, value = "SELECT eventi.*,COUNT(persone.id_persona) AS numeropersone FROM persone,eventi WHERE eventi.durata_evento>?1 AND persone.id_evento=eventi.id_evento GROUP BY (eventi.id_evento) HAVING numeropersone>?2")
	List<Evento> selActiveNumber(int giorni, int numero);
	@Query(nativeQuery = true, value = "SELECT eventi.*, SUM(persone.importo_versato) AS pagato FROM eventi INNER JOIN persone ON eventi.id_evento=persone.id_evento WHERE eventi.luogo_evento =?1 GROUP BY persone.id_evento HAVING eventi.costo_totale > pagato")
	List<Evento> selActivePlace(String luogo);
}
