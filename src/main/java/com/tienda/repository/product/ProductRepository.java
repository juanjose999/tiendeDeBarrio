package com.tienda.repository.product;

import com.tienda.model.product.Producto;
import com.tienda.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Producto> getAllProduct();

    Producto findProductById(String id);

    Producto saveProduct(Producto producto);

    Boolean updateProduct(String id, Producto producto);

    Boolean deleteProductById(String id);
}
