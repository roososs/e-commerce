package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.entity.ProductEntity;
import com.catalog.e_commerce.mapper.CategoryEntityMapper;
import com.catalog.e_commerce.mapper.CategoryMapper;
import com.catalog.e_commerce.mapper.ProductEntityMapper;
import com.catalog.e_commerce.mapper.ProductMapper;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.repository.CatalogJPARepository;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import com.catalog.e_commerce.repository.ProductJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CategoryJpaDao implements CategoryDao{

    @Autowired
    private CatalogJPARepository catalogueJPARepository;
    @Autowired
    private CategoryJPARepository categoryJPARepository;
    @Autowired
    private ProductJPARepository productJPARepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductJpaDao productJpaDao;

    @Override
    public UUID save(String name, String description, UUID catalogueId, UUID categoryParentId) {
        if (catalogueId == null) {
            throw new IllegalArgumentException("Catalogue ID must not be null");
        }

        final var catalogEntity = catalogueJPARepository.findById(catalogueId);
        if (catalogEntity.isEmpty()) {
            throw new EntityNotFoundException("Catalogue not found");
        }

        final var categoryParentEntity = categoryParentId != null ? categoryJPARepository.findById(categoryParentId) : java.util.Optional.empty();
        if (categoryParentId != null && categoryParentEntity.isEmpty()) {
            throw new EntityNotFoundException("Category parent not found");
        }

        return categoryJPARepository.save(new CategoryEntity(name, description, catalogEntity.get(), (CategoryEntity) categoryParentEntity.orElse(null)))
                .getId();
    }

    @Override
    public Category update(Category category) {
        final var categoryEntity = categoryJPARepository.findById(category.id());
        if(categoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        final var catalogEntity = catalogueJPARepository.findById(category.catalogueId());
        if(catalogEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        final var categoryEntityParent = category.categoryParentId() !=null ?
                categoryJPARepository.findById(category.categoryParentId()):
                java.util.Optional.empty();
        if(category.categoryParentId() !=null && categoryJPARepository.findById(category.categoryParentId()).isEmpty())
        {
            throw new EntityNotFoundException();
        }

        CategoryEntity entityToUpdate = categoryEntity.get();
        entityToUpdate.setName(category.name());
        entityToUpdate.setDescription(category.description());
        entityToUpdate.setCatalogEntity(catalogEntity.get());
        entityToUpdate.setCategoryEntityParent((CategoryEntity) categoryEntityParent.orElse(null));
        entityToUpdate.setSubCategories(categoryEntity.get().getSubCategories());
        entityToUpdate.setProductEntities(categoryEntity.get().getProductEntities());

        categoryJPARepository.save(entityToUpdate);
        return categoryMapper.apply(entityToUpdate);
    }

    @Override
    public Category delete(UUID categoryId) {
        final var categoryEntity = categoryJPARepository.findById(categoryId);
        if(categoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        categoryJPARepository.deleteById(categoryId);
        return categoryMapper.apply(categoryEntity.get());
    }


    @Override
    public Category linkSubCategory(UUID categoryId, UUID subCategoryId)
    {
        final var categoryEntity = categoryJPARepository.findById(categoryId);
        if(categoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        // category to be linked
        final var subCategory = categoryJPARepository.findById(subCategoryId);
        if(subCategory.isEmpty()){
            throw new EntityNotFoundException();
        }

        CategoryEntity entityToUpdate = subCategory.get();
        entityToUpdate.setCategoryEntityParent(categoryEntity.get());

        Category category = categoryMapper.apply(entityToUpdate);
        return update(category);
    }

    @Override
    public Category unlinkSubCategory(UUID subCategoryId) {

        final var subCategoryEntity = categoryJPARepository.findById(subCategoryId);
        if( subCategoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        CategoryEntity entityToUpdate = subCategoryEntity.get();
        entityToUpdate.setCategoryEntityParent(null);

        Category category = categoryMapper.apply(entityToUpdate);
        return update(category);

    }

    @Override
    public Product linkProduct(UUID categoryId,UUID productId) {

        final var categoryEntity = categoryJPARepository.findById(categoryId);
        if(categoryEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        final var productEntity = productJPARepository.findById(productId);
        if(productEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        ProductEntity entityToUpdate = productEntity.get();
        entityToUpdate.setCategoryEntity(categoryEntity.get());

        Product product = productMapper.apply(entityToUpdate);
        return productJpaDao.update(product);

    }

    @Override
    public Product unlinkProduct(UUID productId) {

        final var productEntity = productJPARepository.findById(productId);
        if(productEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        ProductEntity entityToUpdate = productEntity.get();
        entityToUpdate.setCategoryEntity(null);

        Product product = productMapper.apply(entityToUpdate);
        return productJpaDao.update(product);
    }
}
