package com.tienda;

import com.tienda.model.csvreader.CsvReader;
import com.tienda.model.product.Producto;
import com.tienda.service.product.ProductServiceImplement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AppSpringBootApplication implements CommandLineRunner {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Producto> productosLeidos = null;
    private static ProductServiceImplement productServiceImplement;

    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootApplication.class, args);
        try {
            CsvReader csvReader = new CsvReader();
            productosLeidos = csvReader.readProductsFromCsv("C:resources\\inventory.csv");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        productServiceImplement = new ProductServiceImplement(productosLeidos);
        runMenu();
    }

    public static void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice, productServiceImplement);
        } while (choice != 6);
    }

    private static void displayMenu() {
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

    public static void handleUserChoice(int choice, ProductServiceImplement productServiceImplement) {
        switch (choice) {
            case 1 -> productServiceImplement.addProduct();
            case 2 -> productServiceImplement.deleteProduct();
            case 3 -> productServiceImplement.editProducts();
            case 4 -> productServiceImplement.allProducts();
            case 5 -> productServiceImplement.findById();
            case 6 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida, intente de nuevo");
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
