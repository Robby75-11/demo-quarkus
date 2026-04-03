package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "corsi")
public class Corso extends PanacheEntity {

    private String nome;

    private String descrizione; // aggiunto campo descrizione

    @ManyToMany
    @JoinTable(
            name = "corso_studente",
            joinColumns = @JoinColumn(name = "corso_id"),
            inverseJoinColumns = @JoinColumn(name = "studente_id")
    )
    private Set<Studente> studenti = new HashSet<>();

    // Costruttori
    public Corso() {}

    public Corso(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public Set<Studente> getStudenti() { return studenti; }
    public void setStudenti(Set<Studente> studenti) { this.studenti = studenti; }
}