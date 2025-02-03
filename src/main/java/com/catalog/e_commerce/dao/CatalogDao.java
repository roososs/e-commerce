package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import java.util.Set;
import java.util.UUID;

public interface CatalogDao {

    public UUID save(String name, Set<UUID> categoryId);

    public Catalog update(Catalog catalog);

    public Catalog delete(UUID catalogId);

    public UUID addCategory(UUID categoryId);

    public Category deleteCategory(UUID categoryId);
}
