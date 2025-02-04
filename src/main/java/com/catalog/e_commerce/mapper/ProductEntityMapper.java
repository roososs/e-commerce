package com.catalog.e_commerce.mapper;

import com.catalog.e_commerce.entity.ProductEntity;
import com.catalog.e_commerce.model.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductEntityMapper implements Function<Product, ProductEntity> {
    @Override
    public ProductEntity apply(Product product) {
        return null;
    }
}
