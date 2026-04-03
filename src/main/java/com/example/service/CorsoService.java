package com.example.service;

import com.example.model.Corso;
import com.example.repository.CorsoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CorsoService {

    @Inject
    CorsoRepository corsoRepository;

    // 📌 GET ALL
    public List<Corso> getAllCorsi() {
        return corsoRepository.listAll();
    }

    // 📌 GET BY ID
    public Corso getCorsoById(Long id) {
        return corsoRepository.findById(id);
    }

    // 📌 CREATE
    @Transactional
    public Corso createCorso(Corso corso) {
        corsoRepository.persist(corso);
        return corso;
    }

    // 📌 UPDATE
    @Transactional
    public Corso updateCorso(Long id, Corso updatedCorso) {
        Corso corso = corsoRepository.findById(id);

        if (corso == null) {
            return null;
        }

        corso.setNome(updatedCorso.getNome());
        corso.setStudenti(updatedCorso.getStudenti());

        return corso;
    }

    // 📌 DELETE
    @Transactional
    public boolean deleteCorso(Long id) {
        return corsoRepository.deleteById(id);
    }
}