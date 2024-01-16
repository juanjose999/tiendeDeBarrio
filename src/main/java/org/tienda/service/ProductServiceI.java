package org.tienda.service;
import org.tienda.model.Producto;

import java.util.List;

public interface ProductServiceI {
    void addProduct(List<Producto> productos);

    void deleteProduct(List<Producto> productos);

    void allProducts(List<Producto> productos);

    void editProducts(List<Producto> productos);

    void addProduct();

    void deleteProduct();
    void findById();

    void findById(List<Producto> productosLeidos);

    void allProducts();
    void editProducts();
}
