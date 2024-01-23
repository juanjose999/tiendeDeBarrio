package org.tienda;

import org.tienda.model.Producto;
import org.tienda.model.ProductsArray;
import org.tienda.service.CsvReader;
import org.tienda.service.ProductService;

import java.io.IOException;
import java.util.*;

//crear un sistema de objetos que nos permita cargar obtos typo producto
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public  static Scanner scanner = new Scanner(System.in);
    public static ProductService productService = new ProductService();
    public static ProductsArray arregloProductos = new ProductsArray();


    public static void main(String[] args) {
        List<Producto> productosLeidos = null;
        try {
            CsvReader csvReader = new CsvReader();
            productosLeidos = csvReader.readProductsFromCsv("C:resources\\inventory.csv");
            arregloProductos.productos = productosLeidos;
        } catch (IOException  e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        //arregloProductos.cargarProducts();
        runMenu(productosLeidos);
    }

    public static void runMenu(List<Producto> productosLeidos) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice, productosLeidos);
        }while (choice != 6);
    }

    private static void displayMenu(){
        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Buscar producto                       |");
        System.out.println("6. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 6)  ");

    }

    public static void handleUserChoice(int choice, List<Producto> productosLeidos){
        switch (choice){
            case 1 -> productService.addProduct(productosLeidos);
            case 2 -> productService.deleteProduct(productosLeidos);
            case 3 -> productService.editProducts(productosLeidos);
            case 4 -> productService.allProducts(productosLeidos);
            case 5 -> productService.findById(productosLeidos);
            case 6 -> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida intente de nuevo");
        }
    }
}
