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
    private String Nombre;
    private String Descripcion;
    private String Categoria;
    private String Etiquetas;
    private double Precio;
    private String UrlFoto;


    public Producto(){

    }

    public Producto( String Nombre, String Descripcion, String Categoria, String Etiquetas, double Precio, String UrlFoto) {
        this.Nombre= Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Etiquetas = Etiquetas;
        this.Precio = Precio;
        this.UrlFoto = UrlFoto;
        //this.fechaCreacion = LocalDateTime.now();
    }
    //constructor con cantidad de stock
    public Producto( String Nombre, String Descripcion, String Categoria, String Etiquetas, double precio, int stock) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Etiquetas = Etiquetas;
        this.Precio = Precio;
    }

    public String getIdentificadorProducto(){
        return idProduct;
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

    public void setEtiquetas(String Etiquetas) {
        this.Etiquetas = Etiquetas;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    /*public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock <= 0){
            System.out.println("producto agotado");
        }else {
            this.stock = stock;
        }
    }*/

    public String getUrlFoto() {
        return UrlFoto;
    }

    public void setUrlFoto(String UrlFoto) {
        this.UrlFoto = UrlFoto;
    }

    /*public String countStock(int stock, int pedido) {
        int calculo = pedido-stock;
        if (calculo<=-1) {
            return "solo tengo disponible, " + getStock();
        }else {
            setStock(calculo);
            return "quedan " + calculo + " en stock.";
        }
    }*/
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
