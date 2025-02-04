package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.entity.ProductEntity;
import com.catalog.e_commerce.mapper.ProductMapper;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import com.catalog.e_commerce.repository.ProductJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@AllArgsConstructor
@Component
public class ProductJpaDao implements ProductDao{

    private final ProductJPARepository productJPARepository;
    private final CategoryJPARepository categoryJPARepository;
    private final ProductMapper productMapper;

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
        final var productEntity = productJPARepository.findById(product.id());
        if(productEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        //categoryId is required
        final var categoryEntity = categoryJPARepository.findById(product.categoryId());
        if(categoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        ProductEntity entityToUpdate = productEntity.get();
        entityToUpdate.setName(product.name());
        entityToUpdate.setDescription(product.description());
        entityToUpdate.setPrice(product.price());
        entityToUpdate.setStock(product.stock());
        entityToUpdate.setCategoryEntity(categoryEntity.get());

        productJPARepository.save(entityToUpdate);
        return productMapper.apply(entityToUpdate);
    }

    @Override
    public Product delete(UUID productId) {
        final var productEntity = productJPARepository.findById(productId);
        if(productEntity.isEmpty()){
            throw new EntityNotFoundException();
        }
        productJPARepository.deleteById(productId);
        return productMapper.apply(productEntity.get());

    }
}
