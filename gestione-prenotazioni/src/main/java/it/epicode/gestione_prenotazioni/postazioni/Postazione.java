package it.epicode.gestione_prenotazioni.postazioni;

import it.epicode.gestione_prenotazioni.edifici.Edificio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postazioni")

public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codice;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;
}
