package com.example.pais_service.service.impl;

import com.example.pais_service.model.Pais;
import com.example.pais_service.repository.PaisRepository;
import com.example.pais_service.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Pais findById(Long id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
    }

    @Override
    public void delete(Pais pais) {
        paisRepository.delete(pais);
    }
} 