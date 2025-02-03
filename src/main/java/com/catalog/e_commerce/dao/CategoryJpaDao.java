package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.repository.CatalogueJPARepository;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import com.catalog.e_commerce.repository.ProductJPARepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.Set;
import java.util.UUID;

public class CategoryJpaDao implements CategoryDao{
    private CatalogueJPARepository catalogueJPARepository;
    private CategoryJPARepository categoryJPARepository;

    @Override
    public UUID save(String name, String description, UUID catalogueId, UUID categoryParentId) {
        final var catalog = catalogueJPARepository.findById(catalogueId);
        if (catalog.isEmpty()){
            throw new EntityNotFoundException();
        }
        final var categoryParent = categoryJPARepository.findById(categoryParentId);
        if (categoryParentId != null && categoryParent.isEmpty()){
                throw  new EntityNotFoundException();
        }
        final var categoryEntity = new CategoryEntity(name, description, catalog.get(), categoryParent.get());
        return categoryJPARepository.save(categoryEntity)
                .getId();
    }

    @Override
    public Catalog update(Catalog catalog) {
        return null;
    }

    @Override
    public UUID delete(UUID catalogId) {
        return null;
    }

    @Override
    public Category addSubCategory(UUID subCategoryId) {
        return null;
    }

    @Override
    public Category deleteSubCategory(UUID subCategoryId) {
        return null;
    }

    @Override
    public UUID addProduct(UUID productId) {
        return null;
    }

    @Override
    public Product deleteProduct(UUID productId) {
        return null;
    }
}
