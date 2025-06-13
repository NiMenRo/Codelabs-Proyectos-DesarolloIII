package com.example.pais_service.controller;

import com.example.pais_service.model.Pais;
import com.example.pais_service.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais-service")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/hola/{nombre}")
    public String holaMundo(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("/paises/{id}")
    public Pais buscarPais(@PathVariable Long id) {
        return paisService.findById(id);
    }
} 