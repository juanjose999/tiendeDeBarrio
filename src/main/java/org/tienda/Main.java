package org.tienda;

import org.tienda.model.Producto;
import org.tienda.model.ProductsArray;
import org.tienda.service.ProductService;

import java.util.*;

//crear un sistema de objetos que nos permita cargar obtos typo producto
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public  static Scanner scanner = new Scanner(System.in);
    public static ProductService productService = new ProductService();
    public static ProductsArray arregloProductos = new ProductsArray();


    public static void main(String[] args) {
        arregloProductos.cargarProducts();
        runMenu();
    }

    public static void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice);
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

    public static void handleUserChoice(int choice){
        switch (choice){
            case 1 -> productService.addProduct();
            case 2 -> productService.deleteProduct();
            case 3 -> productService.editProducts();
            case 4 -> productService.allProducts();
            case 5 -> productService.findById();
            case 6 -> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida intente de nuevo");
        }
    }
}
