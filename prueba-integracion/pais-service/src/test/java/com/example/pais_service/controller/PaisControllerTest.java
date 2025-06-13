package com.example.pais_service.controller;

import com.example.pais_service.model.Pais;
import com.example.pais_service.service.PaisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaisController.class)
public class PaisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaisService paisService;

    @Test
    public void holaMundoTest() throws Exception {
        String nombre = "Mundo";
        this.mockMvc.perform(get("/api/pais-service/hola/{nombre}", nombre))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola " + nombre));
    }

    @Test
    public void buscarPaisTest() throws Exception {
        // Preparación de datos de prueba
        Pais miPais = new Pais("Japon", "Tokio", "Asia");
        when(paisService.findById(any(Long.class))).thenReturn(miPais);

        // Ejecución de prueba y verificación
        this.mockMvc.perform(get("/api/pais-service/paises/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pais", is(miPais.getPais())));
    }
} 