package com.empresa.catalogo.dto;

// DTO de SALIDA — lo que la API devuelve al cliente
// No expone el campo "activo" ni campos sensibles
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private Double precio;
    private String categoria;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}