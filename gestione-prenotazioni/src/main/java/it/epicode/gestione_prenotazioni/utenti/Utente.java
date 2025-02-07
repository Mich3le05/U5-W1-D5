package it.epicode.gestione_prenotazioni.utenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utenti")

public class Utente {

    @Id
    private String username;
    private String nomeCompleto;
    private String email;

}