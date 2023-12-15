package org.tienda;

import org.tienda.model.Product;

import java.util.*;

//crear un sistema de objetos que nos permita cargar obtos typo producto
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public  static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        //prueba intancia de la clase producto

        Product p1 = new Product("cocacola", 10, "botella de gaseosa de vidrio 80ml", "bebidas", "gaseosas", 3400);
        products.add(p1);
        double valorParaCompararPrecio = 3000;
        int romperStock = 11;
        String palabra = "Cocacola";
        System.out.println("------funciones nuevas------");

        System.out.println(p1.esPrecioMayorOMenor(valorParaCompararPrecio, p1.getPrice()));
        System.out.println(p1.countStock(romperStock, p1.getStock()));
        System.out.println(p1.contienePalabra(palabra, p1.getName()));


        runMenu();
    }

    public static void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice);
        }while (choice != 5);
        runMenu();
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
        System.out.println("5. Salir                                  |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 5)  ");

    }

    public static void handleUserChoice(int choice){
        switch (choice){
            case 1 -> addProduct();
            case 2 -> deleteProduct();
            case 3 -> editProduct();
            case 4 -> allProducts();
            case 5 -> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida intente de nuevo");

        }
    }

    private static void addProduct(){
        scanner.nextLine();
        System.out.println("ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.println("ingrese la cantidad de productos disponibles en inventario : ");
        int inventario = scanner.nextInt();
        System.out.println("ingrese la descripcion del producto: ");
        String descripcion = scanner.nextLine();
        System.out.println("ingrese la categoria del producto. ");
        String categoria = scanner.nextLine();
        System.out.println("ingrese la etiqueta del producto: ");
        String etiqueta = scanner.nextLine();
        System.out.println("ingrese el precio del producto: ");
        long precioProducto = scanner.nextInt();
        Product nuevoProduct = new Product(nombreProducto, inventario, descripcion,categoria, etiqueta,precioProducto);
        products.add(nuevoProduct);
        System.out.println("Producto agredado correctamente");;
    }

    private static void deleteProduct(){
        int pDelete;
        System.out.println("elija el codigo del producto a eliminar: ");
        //muestro los productos
        for(Product p : products){
            System.out.println(p);
        }
        //eligo un codigo identificador y lo guardo aca
        pDelete = scanner.nextInt();
        //voy a busca el id entre al lista de productos
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getIdProduct() == pDelete){
                products.remove(i);
                System.out.println("producto borrado.");
                break;
            }
        }

        System.out.println("la lista de producto es: ");
        for(Product p : products){
            System.out.println(p);
        }
    }

    private static void allProducts(){
            System.out.println("los producto en el inventarios son: ");
            for(Product product : products){
                System.out.println(product);
            }
    }

    private static void editProduct(){
        System.out.println("los productos disponibles para editar son : ");
        for(Product p : products){
            System.out.println(p);
        }
        System.out.println("ingrese el codigo del producto a editar: ");
        for (int i = 0; i < products.size(); i++) {
            int pEdit = scanner.nextInt();
            if(products.get(i).getIdProduct() ==   pEdit){

                System.out.println("ingrese el nuevo nombre: ");
                String newName = scanner.next();
                products.get(i).setName(newName);

                System.out.println("ingrese la cantidad e existencia en inventario: ");
                int inventario = scanner.nextInt();
                products.get(i).setStock(inventario);


                scanner.nextLine();
                System.out.println("ingrese la nueva descripcion: ");
                String newDescripcion = scanner.nextLine();
                products.get(i).setDescription(newDescripcion);


                System.out.println("ingrese la nueva categoria: ");
                String newCategoria = scanner.nextLine();
                products.get(i).setCategory(newCategoria);

                System.out.println("ingrese la nueva etiqueta: ");
                String newEtiqueta = scanner.nextLine();
                products.get(i).setTags(newEtiqueta);

                System.out.println("ingrese el nuevo precio: ");
                float newPrice = scanner.nextFloat();
                products.get(i).setPrice(newPrice);

                scanner.nextLine();

                System.out.println("producto actualizado");

            }
        }
    }
}
