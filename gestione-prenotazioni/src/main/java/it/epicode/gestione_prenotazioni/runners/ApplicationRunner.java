package it.epicode.gestione_prenotazioni.runners;

import it.epicode.gestione_prenotazioni.edifici.Edificio;
import it.epicode.gestione_prenotazioni.edifici.EdificioRepository;
import it.epicode.gestione_prenotazioni.postazioni.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;

    public ApplicationRunner(EdificioRepository edificioRepository, PostazioneRepository postazioneRepository) {
        this.edificioRepository = edificioRepository;
        this.postazioneRepository = postazioneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Edificio edificio1 = new Edificio(null, "Edificio A", "Via Roma 1", "Milano");
        edificioRepository.save(edificio1);

        Postazione postazione1 = new Postazione(null, "P001", "Postazione privata", TipoPostazione.PRIVATO, 1, edificio1);
        postazioneRepository.save(postazione1);
    }
}
