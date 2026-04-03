package com.example.repository;

import com.example.model.Studente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class StudenteRepository implements PanacheRepository<Studente> {

    public List<Studente> findByNome(String nome) {
        return list("nome", nome);
    }

    public List<Studente> findByCorsoId(Long corsoId) {
        return list("corso.id", corsoId);
    }
}
