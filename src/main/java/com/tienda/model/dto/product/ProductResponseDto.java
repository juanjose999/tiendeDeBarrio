package com.tienda.model.dto.product;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProductResponseDto {
    private String Nombre;
    private String Descripcion;
    private String Categoria;
    private String Etiquetas;
    private double Precio;
    private String UrlFoto;


    public ProductResponseDto(String Nombre, String Descripcion, String Categoria, String Etiquetas, double Precio, String UrlFoto) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Etiquetas = Etiquetas;
        this.Precio = Precio;
        this.UrlFoto = UrlFoto;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String name) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getEtiquetas() {
        return Etiquetas;
    }

    public void setEtiquetas(String Etiquetas) {
        this.Etiquetas = Etiquetas;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getUrlFoto() {
        return UrlFoto;
    }

    public void setUrlFot(String UrlFot) {
        this.UrlFoto = UrlFoto;
    }


}
