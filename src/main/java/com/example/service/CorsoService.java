package com.example.service;

import com.example.model.Corso;
import com.example.model.Studente;
import com.example.repository.CorsoRepository;
import com.example.repository.StudenteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CorsoService {

    @Inject
    CorsoRepository corsoRepository;

    @Inject
    StudenteRepository studenteRepository;

    public List<Corso> getAllCorsi() {
        return Corso.listAll();
    }

    public Corso getCorsoById(Long id) {
        return corsoRepository.findById(id);
    }

    @Transactional
    public Corso createCorso(Corso corso) {
        corsoRepository.persist(corso);
        return corso;
    }

    @Transactional
    public Corso updateCorso(Long id, Corso corso) {
        Corso existing = corsoRepository.findById(id);
        if (existing == null) return null;

        existing.setNome(corso.getNome());
        existing.setDescrizione(corso.getDescrizione());
        return existing;
    }

    @Transactional
    public boolean deleteCorso(Long id) {
        return corsoRepository.deleteById(id);
    }

    // 📌 Metodo per iscrivere uno studente a un corso
    @Transactional
    public boolean iscriviStudente(Long corsoId, Long studenteId) {
        Corso corso = corsoRepository.findById(corsoId);
        Studente studente = studenteRepository.findById(studenteId);

        if (corso == null || studente == null) {
            return false; // corso o studente non trovato
        }

        // Assumi che Corso abbia: Set<Studente> studenti
        corso.getStudenti().add(studente);

        return true; // iscrizione avvenuta
    }
}