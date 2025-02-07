package it.epicode.gestione_prenotazioni.prenotazioni;

import it.epicode.gestione_prenotazioni.postazioni.Postazione;
import it.epicode.gestione_prenotazioni.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate data;

}