package it.epicode.gestione_prenotazioni.utenti;

import it.epicode.gestione_prenotazioni.prenotazioni.Prenotazione;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "utenti")
public class Utente {
    @Id
    private String userName;
    private String nomeCompleto;
    private String email;
    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Utente{" +
                "userName='" + userName + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}