package com.catalog.e_commerce.service;

import com.catalog.e_commerce.dao.CategoryJpaDao;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryJpaDao categoryJpaDao;

    public UUID addCategory(String name, String description, UUID catalogId, UUID categoryParentId){
        return categoryJpaDao.save(name, description, catalogId, categoryParentId);
    }

    public Category updateCategory(Category category){
        return categoryJpaDao.update(category);
    }

    public Category deleteCategory(UUID categoryId){
        return categoryJpaDao.delete(categoryId);
    }

    public Category linkSubCategory(UUID categoryId, UUID subCategoryId){
        return categoryJpaDao.linkSubCategory(categoryId, subCategoryId);
    }

    public Category unlinkSubCategory(UUID subCategoryId){
        return categoryJpaDao.unlinkSubCategory(subCategoryId);
    }

    public Product linkProduct(UUID categoryId, UUID productId){
        return categoryJpaDao.linkProduct(categoryId, productId);
    }

    public Product unlinkProduct(UUID productId){
        return categoryJpaDao.unlinkProduct(productId);
    }
}
