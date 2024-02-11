package com.tienda.model.dto.product;

import com.tienda.model.product.Producto;

public class ProductMapper {

    public static ProductResponseDto Product_To_ProductResponseDto(Producto producto){
        return new ProductResponseDto(
                producto.getName(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getEtiqueta(),
                producto.getPrecio(),
                producto.getImg()
        );
    }

    public static Producto ProductDto_To_Product (ProductDto productDto){
        return new Producto(
                productDto.getName(),
                productDto.getDescripcion(),
                productDto.getCategoria(),
                productDto.getEtiqueta(),
                productDto.getPrecio(),
                productDto.getImg()
        );
    }

}
