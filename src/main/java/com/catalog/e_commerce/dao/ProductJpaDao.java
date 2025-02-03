package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.entity.ProductEntity;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import com.catalog.e_commerce.repository.ProductJPARepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class ProductJpaDao implements ProductDao{

    private ProductJPARepository productJPARepository;
    private CategoryJPARepository categoryJPARepository;
    @Override
    public UUID save(String name, String description, long price, int stock, UUID categoryId) {
        final var category = categoryJPARepository.findById(categoryId);
        if (category.isEmpty()){
            throw new EntityNotFoundException();
        }
        return productJPARepository.save(new ProductEntity(name, description, price, stock, category.get()))
                .getId();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product delete(UUID productId) {
        return null;
    }
}
