package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import java.util.UUID;

public interface CategoryDao {

    public UUID save(String name, String description, UUID catalogueId, UUID categoryParentId);

    public Category update(Category category);

    public Category delete(UUID categoryId);

    public Category linkSubCategory(UUID categoryId,UUID subCategoryId);

    public Category unlinkSubCategory(UUID subCategoryId);

    public Product linkProduct(UUID categoryId, UUID productId);

    public Product unlinkProduct(UUID productId);
}
