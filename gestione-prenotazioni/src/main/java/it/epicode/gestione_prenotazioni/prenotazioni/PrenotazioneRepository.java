package it.epicode.gestione_prenotazioni.prenotazioni;

import it.epicode.gestione_prenotazioni.utenti.Utente;
import it.epicode.gestione_prenotazioni.postazioni.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
}
