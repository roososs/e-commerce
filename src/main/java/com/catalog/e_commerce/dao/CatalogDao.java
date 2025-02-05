package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import java.util.Set;
import java.util.UUID;

public interface CatalogDao {

    public UUID save(String name);

    public Catalog update(Catalog catalog);

    public Catalog delete(UUID catalogId);

    public UUID linkCategory(UUID categoryId);

    public Category unlinkCategory(UUID categoryId);
}
