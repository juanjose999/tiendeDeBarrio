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

