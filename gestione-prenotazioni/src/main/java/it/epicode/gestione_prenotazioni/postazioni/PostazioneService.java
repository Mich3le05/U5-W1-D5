package it.epicode.gestione_prenotazioni.postazioni;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipoPostazione, citta);
    }
}
