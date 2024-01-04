package org.tienda;

import java.util.Date;

public class Producto {
    private static int contadorProducto = 1;
    private int identificadorProducto;
    private String name;
    private String descripcion;
    private String categoria;
    private String etiqueta;
    private float precio;
    private Date fechaCreacion;

    public Producto( String name, String descripcion, String categoria, String etiqueta, float precio) {
        this.identificadorProducto = contadorProducto++;
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.fechaCreacion = new Date();
    }

    public int getIdentificadorProducto(){
        return identificadorProducto;
    }
    public void setIdentificadorProducto(int identificadorProducto){
        this.identificadorProducto = identificadorProducto;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo del producto=" + identificadorProducto +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", precio=" + precio + '\'' +
                ", fecha De creacion=" + fechaCreacion+
                '}';
    }
}
