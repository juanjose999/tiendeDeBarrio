package com.tienda.model.dto.product;

import java.time.LocalDateTime;

public class ProductDto {
    private String name;
    private String descripcion;
    private String categoria;
    private String etiqueta;
    private double precio;
    private String img;
    private LocalDateTime fechaCreacion;
    private int stock;

    public ProductDto(String name, String descripcion, String categoria, String etiqueta, double precio, String img, LocalDateTime fechaCreacion, int stock) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.img = img;
        this.fechaCreacion = fechaCreacion;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
