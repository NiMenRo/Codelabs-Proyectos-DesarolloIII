package main.java.com.microservicios.pedido.client;

import main.java.com.microservicios.pedido.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "producto-service", url = "${producto-service.url}")
public interface ProductoClient {
    @GetMapping("/productos/productos")
    List<ProductoDTO> obtenerProductos();
}
