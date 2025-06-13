package com.example.pais_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String pais;
    private String capital;
    private String continente;

    public Pais() {
    }

    public Pais(String pais, String capital, String continente) {
        this.pais = pais;
        this.capital = capital;
        this.continente = continente;
    }
} 