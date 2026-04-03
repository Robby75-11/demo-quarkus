package com.example.dto;

import java.time.LocalDate;

public class IscrizioneDto {
    private Long id;
    private Long studenteId;
    private Long corsoId;
    private LocalDate dataIscrizione;

    public IscrizioneDto() {
    }

    public IscrizioneDto(Long id, Long studenteId, Long corsoId, LocalDate dataIscrizione) {
        this.id = id;
        this.studenteId = studenteId;
        this.corsoId = corsoId;
        this.dataIscrizione = dataIscrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudenteId() {
        return studenteId;
    }

    public void setStudenteId(Long studenteId) {
        this.studenteId = studenteId;
    }

    public Long getCorsoId() {
        return corsoId;
    }

    public void setCorsoId(Long corsoId) {
        this.corsoId = corsoId;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    @Override
    public String toString() {
        return "IscrizioneDto{" +
                "id=" + id +
                ", studenteId=" + studenteId +
                ", corsoId=" + corsoId +
                ", dataIscrizione=" + dataIscrizione +
                '}';
    }
}
