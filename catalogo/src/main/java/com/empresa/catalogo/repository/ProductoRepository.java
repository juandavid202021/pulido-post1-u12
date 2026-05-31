package com.empresa.catalogo.repository;

import com.empresa.catalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta derivada: solo productos activos
    List<Producto> findByActivoTrue();
}