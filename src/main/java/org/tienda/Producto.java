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
    private int stock;


    public Producto( String name, String descripcion, String categoria, String etiqueta, float precio) {
        this.identificadorProducto = contadorProducto++;
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.fechaCreacion = new Date();
    }
    //constructor con cantidad de stock
    public Producto( String name, String descripcion, String categoria, String etiqueta, float precio, int stock) {
        this.identificadorProducto = contadorProducto++;
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.fechaCreacion = new Date();
        this.stock = stock;
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
        ", cantidad disponible  =" + stock +
                '}';
    }
}
