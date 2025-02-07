package it.epicode.gestione_prenotazioni.prenotazioni;

import it.epicode.gestione_prenotazioni.postazioni.Postazione;
import it.epicode.gestione_prenotazioni.utenti.Utente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public boolean prenotaPostazione(Utente utente, Postazione postazione, LocalDate data) {
        if (prenotazioneRepository.existsByUtenteAndData(utente, data) ||
                prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            return false;
        }
        Prenotazione prenotazione = new Prenotazione(null, utente, postazione, data);
        prenotazioneRepository.save(prenotazione);
        return true;
    }
}
