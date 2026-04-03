package com.example.repository;

import com.example.model.Iscrizione;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IscrizioneRepository implements PanacheRepository<Iscrizione> {
    // ora puoi fare find, persist, delete, ecc.
}
