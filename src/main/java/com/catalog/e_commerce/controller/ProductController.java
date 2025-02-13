package com.catalog.e_commerce.controller;


import com.catalog.e_commerce.dto.ProductDto;
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
    public ResponseEntity<UUID> addProduct(@RequestBody ProductDto productDto){
        UUID productId = productService.addProduct(productDto.name(),productDto.description(), productDto.price(), productDto.stock(), productDto.categoryId());
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }


}
