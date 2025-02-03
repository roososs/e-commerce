package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;

import java.util.Set;
import java.util.UUID;

public interface CategoryDao {
    public UUID save(String name, String description, UUID catalogueId, UUID categoryParentId);

    public Catalog update(Catalog catalog);

    public UUID delete(UUID catalogId);

    public Category addSubCategory(UUID subCategoryId);

    public Category deleteSubCategory(UUID subCategoryId);

    public UUID addProduct(UUID productId);

    public Product deleteProduct(UUID productId);
}
