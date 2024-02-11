package com.tienda.model.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Document(collection = "product")
public class Producto implements Serializable {
    private static long serialVersionUID= 1L;
    @Id
    private String idProduct;
    private String name;
    private String descripcion;
    private String categoria;
    private String etiqueta;
    private double precio;
    private String img;
    private LocalDateTime fechaCreacion;
    private int stock;

    public Producto(){

    }

    public Producto( String name, String descripcion, String categoria, String etiqueta, double precio, String img) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.img = img;
        this.fechaCreacion = LocalDateTime.now();
    }
    //constructor con cantidad de stock
    public Producto( String name, String descripcion, String categoria, String etiqueta, double precio, int stock) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.fechaCreacion = LocalDateTime.now();
        this.stock = stock;
    }

    public String getIdentificadorProducto(){
        return idProduct;
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
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock <= 0){
            System.out.println("producto agotado");
        }else {
            this.stock = stock;
        }
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String countStock(int stock, int pedido) {
        int calculo = pedido-stock;
        if (calculo<=-1) {
            return "solo tengo disponible, " + getStock();
        }else {
            setStock(calculo);
            return "quedan " + calculo + " en stock.";
        }
    }
    //metodo para validar si el precio del producto es mayor o menor a uno ingresado por el usuario
    public String esPrecioMayorOMenor(double valorComparacion, double precio) {
        if(precio < valorComparacion){
            return "el precio del producto es menor, puedes llevar otro producto.";
        } else {
            return "el precio del producto es mayor, no te alcanza.";
        }
    }

    //metodo para validar si una palabra pasado existe como numbre de una instancia de producto
    public String contienePalabra(String palabra, String buscar) {
        if(palabra.equalsIgnoreCase(buscar)){
            return "el nombre del producto si existe en nuestro inventario.";
        } else {
            return "producto no disponible.";
        }
    }

}
