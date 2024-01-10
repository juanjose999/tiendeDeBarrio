package org.tienda.service;

import org.tienda.model.Producto;
import org.tienda.model.ProductsArray;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductService implements ProductServiceI{
    public  static Scanner scanner = new Scanner(System.in);

    private static List<Producto> productos;
    public ProductService(){
        this.productos = new ArrayList<>();
    }


    @Override
    public void addProduct() {
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
            ProductsArray.productos.add(nuevoProducto);
            System.out.println(nuevoProducto.toString());
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor válido.");
            scanner.nextLine(); // Limpia el buffer del scanner
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("Lista de productos disponibles: ");
        //muestro los productos
        for(Producto p : ProductsArray.productos){
            System.out.println(p);
        }
        System.out.println("Ingrese el codigo del producto a eliminar.");
        int productoId = scanner.nextInt();

        boolean productoEncontrado = false;
        for (int i = 0; i < ProductsArray.productos.size(); i++) {
            if(ProductsArray.productos.get(i).getIdentificadorProducto() == productoId){
                ProductsArray.productos.remove(i);
                productoEncontrado =true;
                System.out.println("Producto eliminado correctamente.");
                break;
            }
        }
        if (!productoEncontrado){
            System.out.println("no se encontro el producto.");
        }

    }

    @Override
    public void allProducts() {
        System.out.println("en orden");
        ProductsArray.productosEnOrden();
        System.out.println("en desorden");
        for(Producto producto : ProductsArray.productos){
            System.out.println(producto);

        }
    }

    @Override
    public void editProducts() {
        System.out.println("los productos disponibles para editar son : ");
        for(Producto p : ProductsArray.productos){
            System.out.println(p);
        }
        System.out.println("ingrese el codigo del producto a editar: ");
        int pEdit = scanner.nextInt();

        boolean productoEncontrado = false;
        for (int i = 0; i < ProductsArray.productos.size(); i++) {
            if(ProductsArray.productos.get(i).getIdentificadorProducto() ==   pEdit){

                System.out.println("ingrese el nuevo nombre: ");
                String newName = scanner.next();
                ProductsArray.productos.get(i).setName(newName);

                scanner.nextLine();
                System.out.println("ingrese la nueva descripcion: ");
                String newDescripcion = scanner.nextLine();
                ProductsArray.productos.get(i).setDescripcion(newDescripcion);


                System.out.println("ingrese la nueva categoria: ");
                String newCategoria = scanner.nextLine();
                ProductsArray.productos.get(i).setCategoria(newCategoria);

                System.out.println("ingrese la nueva etiqueta: ");
                String newEtiqueta = scanner.nextLine();
                ProductsArray.productos.get(i).setEtiqueta(newEtiqueta);

                System.out.println("ingrese el nuevo precio: ");
                float newPrice = scanner.nextFloat();
                ProductsArray.productos.get(i).setPrecio(newPrice);

                scanner.nextLine();

                System.out.println("producto actualizado");
                productoEncontrado = true;
                break;
            }
        }
        if(!productoEncontrado){
            System.out.println("No se encontro el producto");
        }
    }
    @Override
    public void findById() {
        boolean encontrado = false;
        do {
            System.out.println("Buscador de productos, " +
                    "para buscar por nombre ingrese, 1 \npara buscar por Id ingrese, 2");
            int optionBuscar = scanner.nextInt();
            scanner.nextLine(); // Consume el carácter de nueva línea

            switch (optionBuscar) {
                case 1:
                    System.out.println("Ingrese el nombre del producto");
                    String nombreProductoBuscar = scanner.nextLine();

                    for (Producto producto : ProductsArray.productos) {
                        if (producto.getName().equalsIgnoreCase(nombreProductoBuscar)) {
                            encontrado = true;
                            System.out.println(producto);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el id del producto");
                    int idProductoBuscar = scanner.nextInt();
                    scanner.nextLine(); // Consume el carácter de nueva línea

                    for (Producto producto : ProductsArray.productos) {
                        if (producto.getIdentificadorProducto() == idProductoBuscar) {
                            encontrado = true;
                            System.out.println(producto);
                        }
                    }
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        } while (!encontrado);
    }

}
