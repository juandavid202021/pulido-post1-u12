package com.empresa.catalogo.service;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;
import com.empresa.catalogo.entity.Producto;
import com.empresa.catalogo.exception.RecursoNoEncontradoException;
import com.empresa.catalogo.factory.ProductoFactory;
import com.empresa.catalogo.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private static final Logger log =
            LoggerFactory.getLogger(ProductoServiceImpl.class);

    private final ProductoRepository repo;
    private final ProductoFactory factory;

    public ProductoServiceImpl(ProductoRepository repo, ProductoFactory factory) {
        this.repo = repo;
        this.factory = factory;
    }

    @Override
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        log.info("Creando producto: nombre={}, categoria={}",
                dto.getNombre(), dto.getCategoria());
        Producto p = factory.toEntity(dto);
        ProductoResponseDTO resp = factory.toResponseDTO(repo.save(p));
        log.info("Producto creado exitosamente con id={}", resp.getId());
        return resp;
    }

    @Override
    public ProductoResponseDTO buscarPorId(Long id) {
        log.debug("Buscando producto con id={}", id);
        Producto p = repo.findById(id).orElseThrow(() -> {
            log.warn("Producto con id={} no encontrado", id);
            return new RecursoNoEncontradoException("Producto", id);
        });
        return factory.toResponseDTO(p);
    }

    @Override
    public List<ProductoResponseDTO> listarActivos() {
        log.debug("Listando todos los productos activos");
        return repo.findByActivoTrue().stream()
                .map(factory::toResponseDTO)
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        log.info("Eliminando producto con id={}", id);
        buscarPorId(id);
        repo.deleteById(id);
        log.info("Producto con id={} eliminado correctamente", id);
    }
}