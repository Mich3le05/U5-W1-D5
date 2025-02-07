package it.epicode.gestione_prenotazioni.postazioni;


import it.epicode.gestione_prenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.gestione_prenotazioni.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void inserisciPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public Postazione getPostazioneById(Integer id) {
        return postazioneRepository.findById(id).orElseThrow();
    }
}