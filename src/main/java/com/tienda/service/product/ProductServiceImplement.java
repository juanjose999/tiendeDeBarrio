package com.tienda.service.product;

import com.tienda.model.product.Producto;

import java.util.*;

public class ProductServiceImplement implements ProductService {
    public  static Scanner scanner = new Scanner(System.in);

    private List<Producto> productos;
    public ProductServiceImplement(List<Producto> productosLeidos){
        productos = productosLeidos;
    }


    @Override
    public void addProduct() {
        try {
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

    @Override
    public void deleteProduct() {
        System.out.println("Lista de productos disponibles: ");
        //muestro los productos
        for(Producto p : productos){
            System.out.println(p);
        }
        System.out.println("Ingrese el codigo del producto a eliminar.");
        int productoId = scanner.nextInt();

        boolean productoEncontrado = false;
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getIdentificadorProducto() == productoId){
                productos.remove(i);
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
        productosEnOrden(productos);
    }

    public static void productosEnOrden(List<Producto> productos){
        Producto[] produstosOrdenadosAlfabeticamente = productos.stream()
                .filter(producto -> producto != null)
                .toArray(Producto[]::new);

        Arrays.sort(produstosOrdenadosAlfabeticamente, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("lista de productos ordenados alfabeticamente: ");
        for(Producto producto: produstosOrdenadosAlfabeticamente){
            System.out.println(producto);
        }
    }

    @Override
    public void editProducts() {
        System.out.println("los productos disponibles para editar son : ");
        for(Producto p : productos){
            System.out.println(p);
        }
        System.out.println("ingrese el codigo del producto a editar: ");
        int pEdit = scanner.nextInt();

        boolean productoEncontrado = false;
        for (int i = 0; i < productos.size(); i++) {
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
            System.out.println("Buscador de productos: " +
                    "\npara buscar por nombre ingrese, 1. \npara buscar por Id ingrese, 2");
            int optionBuscar = scanner.nextInt();
            scanner.nextLine(); // Consume el carácter de nueva línea

            switch (optionBuscar) {
                case 1:
                    System.out.println("Ingrese el nombre del producto");
                    String nombreProductoBuscar = scanner.nextLine();

                    for (Producto producto : productos) {
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

                    for (Producto producto : productos) {
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
