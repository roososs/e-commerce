package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.model.Product;

import java.util.UUID;

public interface ProductDao {
    public UUID save(String name, String description, long price, int stock, UUID categoryId);

    public Product update(Product product);

    public Product delete(UUID productId);
}
