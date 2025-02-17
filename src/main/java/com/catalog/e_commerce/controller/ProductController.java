package com.catalog.e_commerce.controller;


import com.catalog.e_commerce.dto.ProductAddDto;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<UUID> addProduct(@RequestBody ProductAddDto productAddDto){
        UUID productId = productService.addProduct(productAddDto.name(), productAddDto.description(), productAddDto.price(), productAddDto.stock(), productAddDto.categoryId());
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productUpdated = productService.updateProduct(product);
        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }


}
