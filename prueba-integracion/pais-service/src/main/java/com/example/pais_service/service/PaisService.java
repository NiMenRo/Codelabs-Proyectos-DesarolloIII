package com.example.pais_service.service;

import com.example.pais_service.model.Pais;

public interface PaisService {
    Pais save(Pais pais);
    Pais findById(Long id);
    void delete(Pais pais);
} 