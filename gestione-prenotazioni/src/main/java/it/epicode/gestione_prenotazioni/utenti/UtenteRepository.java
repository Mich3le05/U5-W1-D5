package it.epicode.gestione_prenotazioni.utenti;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    public Utente findByUserName(String userName);
}