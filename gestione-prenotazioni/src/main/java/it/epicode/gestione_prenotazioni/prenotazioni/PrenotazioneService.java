package it.epicode.gestione_prenotazioni.prenotazioni;

import it.epicode.gestione_prenotazioni.postazioni.Postazione;
import it.epicode.gestione_prenotazioni.postazioni.PostazioneRepository;
import it.epicode.gestione_prenotazioni.postazioni.TipoPostazione;
import it.epicode.gestione_prenotazioni.utenti.Utente;
import it.epicode.gestione_prenotazioni.utenti.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Postazione> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipo, citta);
    }

    @Transactional
    public Prenotazione prenotaPostazione(String userName, Integer postazioneId, LocalDate data) throws Exception {
        Utente utente = utenteRepository.findByUserName(userName);
        if (utente == null) {
            throw new Exception("Utente non trovato");
        }
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));

        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndData(utente, data);
        if (!prenotazioniUtente.isEmpty()) {
            throw new Exception("L'utente ha già una prenotazione per questa data");
        }

        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAndData(postazione, data);
        if (!prenotazioniPostazione.isEmpty()) {
            if (prenotazioniPostazione.size() + 1 > postazione.getMaxOccupanti()) {
                throw new Exception("La postazione è occupato in quella data");
            }
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setData(data);

        return prenotazioneRepository.save(prenotazione);
    }
}
