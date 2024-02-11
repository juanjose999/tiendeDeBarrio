package com.tienda.service.product;

import com.tienda.model.dto.product.ProductDto;
import com.tienda.model.dto.product.ProductResponseDto;
import com.tienda.model.product.Producto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProduct();

    ProductResponseDto findProductById(String id);

    ProductResponseDto saveProduct(ProductDto productoDto);

    Boolean updateProduct(String id, ProductDto productDto);

    Boolean deleteProductById(String id);

}
