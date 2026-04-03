package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "iscrizioni")
public class Iscrizione extends PanacheEntity {


@ManyToOne
    @JoinColumn (name= "studente_id")
    private Studente studente;

@ManyToOne
    @JoinColumn (name = "corso_id")
    private Corso corso;

private LocalDate dataIscrizione;
    public Iscrizione() {
    }

    public Iscrizione(Studente studente, Corso corso, LocalDate dataIscrizione) {
        this.studente = studente;
        this.corso = corso;
        this.dataIscrizione = dataIscrizione;
    }



    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
}
