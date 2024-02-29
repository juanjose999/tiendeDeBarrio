package com.tienda.controller.product;

import com.tienda.model.dto.product.ProductDto;
import com.tienda.model.dto.product.ProductResponseDto;
import com.tienda.model.product.Producto;
import com.tienda.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        List<ProductResponseDto> response = productService.getAllProduct();
        System.out.println("Response: " + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable String id){
        try {
            ProductResponseDto responseDto = productService.findProductById(id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto),HttpStatus.CREATED);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Boolean> updateProduct(@PathVariable String idProduct, @RequestBody ProductDto productDto){
        try{
            Boolean isUpdateProduct = productService.updateProduct(idProduct, productDto);
            if(isUpdateProduct){
                return new ResponseEntity("the product update is ok.", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the product " + idProduct + " does't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable String idProduct){
        return new ResponseEntity<>(productService.deleteProductById(idProduct), HttpStatus.OK);
    }
}
