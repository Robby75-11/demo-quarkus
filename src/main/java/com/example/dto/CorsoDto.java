package com.example.dto;

import java.util.List;

public class CorsoDto {
private Long id;
private String nome;
private List<Long> studentiIds;

    public CorsoDto() {
    }

    public CorsoDto(Long id, String nome, List<Long> studentiIds) {
        this.id = id;
        this.nome = nome;
        this.studentiIds = studentiIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getStudentiIds() {
        return studentiIds;
    }

    public void setStudentiIds(List<Long> studentiIds) {
        this.studentiIds = studentiIds;
    }
}
