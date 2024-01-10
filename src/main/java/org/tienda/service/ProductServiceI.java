package org.tienda.service;
import org.tienda.model.Producto;

public interface ProductServiceI {
    void addProduct();

    void deleteProduct();
    void findById();
    void allProducts();
    void editProducts();
}
