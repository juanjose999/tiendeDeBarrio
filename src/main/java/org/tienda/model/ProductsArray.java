package org.tienda.model;

import org.tienda.model.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductsArray {
    public static List<Producto> productos;

    public ProductsArray() {
        this.productos = new ArrayList<>();
    }

    public void cargarProducts(Producto[] productosPredefinidos){
        this.productos.addAll(Arrays.asList(productosPredefinidos));

    }

    public void cargarProducts() {
        Producto[] productosPredefinidos = {
                new Producto("leche", "Leche Entera Alpina", "lacteos", "Bolsa x 1.100 ml", 4200),
                new Producto("papas fritas", "Papas fritas", "fritos", "Bolsa x 1.100 ml", 4100),
                new Producto("yogurt", "Yogurt", "lacteos", "Bolsa x 1.100 ml", 2900),
                new Producto("bonYour", "BonYour", "Lacteos", "Vaso x 196 ml", 4600),
                new Producto("papas margaritas", "Papas Margarita de Todito natural", "fritos", "Bolsa x 400", 6600),
                new Producto("choclitos", "Choclitos Margarita", "fritos", "Bolsa x 130gr", 3300),
                new Producto("mortadela", "Mortadela Rica", "carnes", "Bolsa x 240gr", 5400),
                new Producto("papas yupi", "Papas Yupi Rizadas", "fritos", "Bolsa x 130gr", 12999),
                new Producto("jamon zenu", "Jamon Zenu", "carnes", "Bolsa x 240gr", 54000),
                new Producto("jamon pietran", "Jamon pietran", "carnes", "Bolsa x 250gr", 12400),
                new Producto("salchicha rica", "Sachicha Rica", "carnes", "Bolsa x 450gr", 5400),
                new Producto("chorizo rica", "Chorizo Rica", "carnes", "Bolsa x 660gr", 3400),
                new Producto("morcilla colanta", "Morcilla Colanta", "carnes", "Bolsa x 4 unidades", 12200),
                new Producto("rollo de carne", "Rollo de carne", "carnes", "Bolsa x 220gr", 5439),
                new Producto("huevo tipo A", "Huevo tipo A", "carnes", "Cubeta 30", 3433),
                new Producto("queso alpina", "Queso alpina Campesino", "lacteos", "Bolsa x 120gr", 2422),
                new Producto("margarita", "Margarina La Fina", "lacteos", "Barra x 12gr", 3400),
                new Producto("mantequilla", "Mantequilla rama", "lacteos", "Barra x 8gr", 5420),
                new Producto("crema de leche", "Crema de leche Alqueria", "lacteos", "Bolsa x 900ml", 4400),
                new Producto("kumis", "Kumis Alpina", "lacteos", "Vaso x 12gr", 5400),
        };
        this.productos.addAll(Arrays.asList(productosPredefinidos));
    }
    public static void buscarLetraInicial (){
        Scanner input = new Scanner(System.in);
        char letraInicial = input.next().charAt(0);
        System.out.println("productos que comienzan por la letra " + letraInicial + ": ");
        for (Producto producto: productos){
            if (producto != null && Character.toLowerCase(producto.getName().charAt(0)) == Character.toLowerCase(letraInicial)) {
                System.out.println(producto);
            }
        }
    }
    public static void productosEnOrden(){
        Producto[] produstosOrdenadosAlfabeticamente = productos.stream()
                .filter(producto -> producto != null)
                .toArray(Producto[]::new);

        Arrays.sort(produstosOrdenadosAlfabeticamente, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("lista de productos ordenados alfabeticamente: ");
        for(Producto producto: produstosOrdenadosAlfabeticamente){
            System.out.println(producto);
        }
    }

    public String toString(){
        StringBuilder resultado = new StringBuilder();
        for(Producto producto: productos){
            if(producto!=null){
                resultado.append(producto).append("\n");
            }
        }
        return resultado.toString();
    }
}

