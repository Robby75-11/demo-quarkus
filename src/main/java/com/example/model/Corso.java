package com.example.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Table(name= "corsi")
@Entity
public class Corso extends PanacheEntity {
    public Corso() {
    }

    public Corso(String nome, List<Studente> studenti) {
        this.nome = nome;
        this.studenti = studenti;
    }

    private String nome;


    @OneToMany (mappedBy = "corso")
    private List<Studente>studenti;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }
}
