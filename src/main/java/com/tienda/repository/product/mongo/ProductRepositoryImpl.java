package com.tienda.repository.product.mongo;

import com.tienda.model.product.Producto;
import com.tienda.model.user.User;
import com.tienda.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMongoRepository productMongoRepository;


    @Override
    public List<Producto> getAllProduct() {
        return productMongoRepository.findAll();
    }

    @Override
    public Producto findProductById(String id) {
        return productMongoRepository.findById(id).get();
    }

    @Override
    public Producto saveProduct(Producto producto) {
        return productMongoRepository.save(producto);
    }

    @Override
    public Boolean updateProduct(String id, Producto producto) {
        Producto foundProduct = findProductById(id);
        if(foundProduct != null){
            foundProduct.setName(producto.getName());
            foundProduct.setDescripcion(producto.getDescripcion());
            foundProduct.setCategoria(producto.getCategoria());
            foundProduct.setEtiqueta(producto.getEtiqueta());
            foundProduct.setPrecio(producto.getPrecio());
            foundProduct.setImg(producto.getImg());

            productMongoRepository.save(foundProduct);
            return true;
        }
        return null;
    }

    @Override
    public Boolean deleteProductById(String id) {
        Producto foundProduct = findProductById(id);
        if (foundProduct != null) {
            productMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
