package com.tienda.model.dto.product;

import java.time.LocalDateTime;

public class ProductDto {
    private String Nombre;
    private String Descripcion;
    private String Categoria;
    private String Etiquetas;
    private double Precio;
    private String UrlFoto;
    //private LocalDateTime fechaCreacion;
    private int stock;

    public ProductDto(String Nombre, String Descripcion, String Categoria, String Etiquetas, double Precio, String UrlFoto,  int stock) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Etiquetas = Etiquetas;
        this.Precio = Precio;
        this.UrlFoto = UrlFoto;
        //this.fechaCreacion = fechaCreacion;
        //this.stock = stock;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
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

    public void setEtiquetas(String etiqueta) {
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

    public void setUrlFoto(String UrlFoto) {
        this.UrlFoto = UrlFoto;
    }



    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
