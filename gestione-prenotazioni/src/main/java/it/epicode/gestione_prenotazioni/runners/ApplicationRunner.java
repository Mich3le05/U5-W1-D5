package it.epicode.gestione_prenotazioni.runners;

import it.epicode.gestione_prenotazioni.GestionePrenotazioniApplication;
import it.epicode.gestione_prenotazioni.edifici.Edificio;
import it.epicode.gestione_prenotazioni.edifici.EdificioService;
import it.epicode.gestione_prenotazioni.postazioni.Postazione;
import it.epicode.gestione_prenotazioni.postazioni.PostazioneService;
import it.epicode.gestione_prenotazioni.postazioni.TipoPostazione;
import it.epicode.gestione_prenotazioni.prenotazioni.Prenotazione;
import it.epicode.gestione_prenotazioni.prenotazioni.PrenotazioneService;
import it.epicode.gestione_prenotazioni.utenti.Utente;
import it.epicode.gestione_prenotazioni.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties")
public class ApplicationRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);


        Edificio edificio = (Edificio) ctx.getBean("edificio1");
        edificioService.inserisciEdificio(edificio);
        try {
            Edificio edificio1 = edificioService.getEdificioById(1);
            Postazione postazione1 = new Postazione();
            postazione1.setEdificio(edificio1);
            postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
            postazione1.setMaxOccupanti(1);
            postazione1.setDescrizione("Postazione n°1");
            postazioneService.inserisciPostazione(postazione1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            Edificio edificio1 = edificioService.getEdificioById(1);
            Postazione postazione2 = new Postazione();
            postazione2.setEdificio(edificio1);
            postazione2.setTipoPostazione(TipoPostazione.OPENSPACE);
            postazione2.setMaxOccupanti(5);
            postazione2.setDescrizione("Postazione n°2");
            postazioneService.inserisciPostazione(postazione2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Utente utente1 = new Utente();
        utente1.setUserName("Mich3ele");
        utente1.setEmail("michele@gmail.cmo");
        utente1.setNomeCompleto("Michele Rossi");
        utenteService.inserisciUtente(utente1);


        try {
            Prenotazione prenotazione = prenotazioneService.prenotaPostazione("Mich3ele", 1, LocalDate.now().plusMonths(1));
            System.out.println(prenotazione);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}