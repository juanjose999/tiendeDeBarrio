package com.tienda.repository.product;

import com.tienda.model.product.Producto;
import com.tienda.repository.product.mongo.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        Optional<Producto> foundProductOptional = Optional.ofNullable(findProductById(id));
        if (foundProductOptional.isPresent()) {
            Producto existingProduct = foundProductOptional.get();
            existingProduct.setNombre(producto.getNombre());
            existingProduct.setDescripcion(producto.getDescripcion());
            existingProduct.setCategoria(producto.getCategoria());
            existingProduct.setEtiquetas(producto.getEtiquetas());
            existingProduct.setPrecio(producto.getPrecio());
            existingProduct.setUrlFoto(producto.getUrlFoto());

            productMongoRepository.save(existingProduct);
            return true;
        }
        return false;
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
