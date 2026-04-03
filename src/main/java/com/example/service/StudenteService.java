package com.example.service;

import com.example.model.Studente;
import com.example.repository.StudenteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class StudenteService {
    @Inject
    StudenteRepository studenteRepository;

    public List<Studente> getAllStudenti() {
        return studenteRepository.listAll();
    }

    public Studente getStudenteById(Long id) {
        return studenteRepository.findById(id);
    }

    @Transactional
    public Studente createStudente(Studente studente) {
        studenteRepository.persist(studente);
        return studente;
    }

    @Transactional
    public Studente updateStudente(Long id, Studente studenteData) {
        Studente studente = studenteRepository.findById(id);
        if (studente != null) {
            studente.setNome  (studenteData.getNome());
            studente.setCognome ( studenteData.getCognome());
            studente.setEmail  (studenteData.getEmail());
            studente.setDataNascita (studenteData.getDataNascita());
            studente.setCorso (studenteData.getCorso());
        }
        return studente;
    }

    @Transactional
    public boolean deleteStudente(Long id) {
        return studenteRepository.deleteById(id);
    }
}

