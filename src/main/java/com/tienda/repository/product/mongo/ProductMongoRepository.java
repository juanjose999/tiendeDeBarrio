package com.tienda.repository.product.mongo;

import com.tienda.model.product.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Producto, String> {
}
