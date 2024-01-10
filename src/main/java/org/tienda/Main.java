package org.tienda;

import org.tienda.model.Producto;
import org.tienda.model.ProductsArray;

import java.util.*;

//crear un sistema de objetos que nos permita cargar obtos typo producto
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public  static Scanner scanner = new Scanner(System.in);
    static List<Producto> productos = new ArrayList<>();
    public static ProductsArray arregloProductos = new ProductsArray();


    public static void main(String[] args) {
        arregloProductos.cargarProducts();
        System.out.println(arregloProductos);
        arregloProductos.buscarLetraInicial();
        arregloProductos.productosEnOrden();
        runMenu();
    }

    public static void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice);
        }while (choice != 5);
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

    private static void addProduct() {
        try {
            scanner.nextLine();
            System.out.println("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.println("Ingrese la descripción del producto: ");
            String descripcion = scanner.nextLine();
            System.out.println("Ingrese la categoría del producto: ");
            String categoria = scanner.nextLine();
            System.out.println("Ingrese la etiqueta del producto: ");
            String etiqueta = scanner.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            float precioProducto = scanner.nextFloat();
            System.out.println("Ingrese el stock del producto: ");
            int stock = scanner.nextInt();

            // Verifica si el stock ingresado es válido
            if (stock < 0) {
                throw new IllegalArgumentException("El stock no puede ser negativo");
            }

            Producto nuevoProducto = new Producto(nombreProducto, descripcion, categoria, etiqueta, precioProducto, stock);
            productos.add(nuevoProducto);
            System.out.println(nuevoProducto.toString());
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor válido.");
            scanner.nextLine(); // Limpia el buffer del scanner
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteProduct(){
        int pDelete;
        System.out.println("elija el codigo del producto a eliminar: ");
        //muestro los productos
        for(Producto p : productos){
            System.out.println(p);
        }
        //eligo un codigo identificador y lo guardo aca
        pDelete = scanner.nextInt();
        //voy a busca el id entre al lista de productos
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getIdentificadorProducto() == pDelete){
                productos.remove(i);
                System.out.println("producto borrado.");
                break;
            }
        }

        System.out.println("la lista de producto es: ");
        for(Producto p : productos){
            System.out.println(p);
        }
    }

    private static void allProducts(){
        System.out.println("Ingrese 1 para ver en orden , 2 para ver en desorde.");
        int optionNum = scanner.nextInt();
        if(optionNum==1){
            ProductsArray.productosEnOrden();
        }else if(optionNum==2){
            System.out.println("los producto del inventario en desorden son: ");
            for(Producto producto : ProductsArray.productos){
                System.out.println(producto);
            }
        } else {
            System.out.println("entreda invalida, ingrese nuevameente.");
        }
    }

    private static void editProduct(){
        System.out.println("los productos disponibles para editar son : ");
        for(Producto p : productos){
            System.out.println(p);
        }
        System.out.println("ingrese el codigo del producto a editar: ");
        for (int i = 0; i < productos.size(); i++) {
            int pEdit = scanner.nextInt();
            if(productos.get(i).getIdentificadorProducto() ==   pEdit){

                System.out.println("ingrese el nuevo nombre: ");
                String newName = scanner.next();
                productos.get(i).setName(newName);

                scanner.nextLine();
                System.out.println("ingrese la nueva descripcion: ");
                String newDescripcion = scanner.nextLine();
                productos.get(i).setDescripcion(newDescripcion);


                System.out.println("ingrese la nueva categoria: ");
                String newCategoria = scanner.nextLine();
                productos.get(i).setCategoria(newCategoria);

                System.out.println("ingrese la nueva etiqueta: ");
                String newEtiqueta = scanner.nextLine();
                productos.get(i).setEtiqueta(newEtiqueta);

                System.out.println("ingrese el nuevo precio: ");
                float newPrice = scanner.nextFloat();
                productos.get(i).setPrecio(newPrice);

                scanner.nextLine();

                System.out.println("producto actualizado");
            }
        }
    }
}
