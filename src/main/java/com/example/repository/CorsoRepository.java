package com.example.repository;

import com.example.model.Corso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CorsoRepository implements PanacheRepository<Corso> {
}
