package com.empresa.microservicio.application.usecase;

import com.empresa.microservicio.domain.model.Producto;
import com.empresa.microservicio.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BuscarProductoPorIdUseCase {
    private final ProductoRepository productoRepository;

    public BuscarProductoPorIdUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto ejecutar(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
} 