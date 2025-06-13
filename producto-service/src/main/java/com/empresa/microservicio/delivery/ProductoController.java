package com.empresa.microservicio.delivery;

import com.empresa.microservicio.application.usecase.ListarProductosUseCase;
import com.empresa.microservicio.application.usecase.BuscarProductoPorIdUseCase;
import com.empresa.microservicio.domain.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ListarProductosUseCase listarProductosUseCase;
    private final BuscarProductoPorIdUseCase buscarProductoPorIdUseCase;

    public ProductoController(
            ListarProductosUseCase listarProductosUseCase,
            BuscarProductoPorIdUseCase buscarProductoPorIdUseCase) {
        this.listarProductosUseCase = listarProductosUseCase;
        this.buscarProductoPorIdUseCase = buscarProductoPorIdUseCase;
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return listarProductosUseCase.ejecutar();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return buscarProductoPorIdUseCase.ejecutar(id);
    }
} 