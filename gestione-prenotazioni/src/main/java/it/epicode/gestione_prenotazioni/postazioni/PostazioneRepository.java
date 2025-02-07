package it.epicode.gestione_prenotazioni.postazioni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipo, String citta);
}