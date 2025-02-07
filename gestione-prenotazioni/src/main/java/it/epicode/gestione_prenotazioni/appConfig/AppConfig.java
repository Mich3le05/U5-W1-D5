package it.epicode.gestione_prenotazioni.appConfig;

import it.epicode.gestione_prenotazioni.edifici.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name = "edificio1")
    @Scope("prototype")
    public Edificio edificio() {
        Edificio edificio = new Edificio();
        edificio.setCitta("Castroreale");
        edificio.setIndirizzo("Via Castello 1");
        edificio.setNome("Epicode");
        return edificio;
    }
}