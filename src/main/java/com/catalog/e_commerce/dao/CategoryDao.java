package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import java.util.UUID;

public interface CategoryDao {

    public UUID save(String name, String description, UUID catalogueId, UUID categoryParentId);

    public Category update(Category category);

    public UUID delete(UUID categoryId);

    public Category addSubCategory(UUID categoryParent,UUID subCategoryId);

    public Category deleteSubCategory(UUID subCategoryId);

    public UUID addProduct(UUID productId);

    public Product deleteProduct(UUID productId);
}
