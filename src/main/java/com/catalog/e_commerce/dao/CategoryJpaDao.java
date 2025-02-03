package com.catalog.e_commerce.dao;
import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.mapper.CategoryMapper;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.repository.CatalogJPARepository;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CategoryJpaDao implements CategoryDao{

    private CatalogJPARepository catalogueJPARepository;
    private CategoryJPARepository categoryJPARepository;
    private CategoryMapper categoryMapper;

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
    public Category update(Category category) {
        return null;
    }

    @Override
    public UUID delete(UUID categoryId) {
        return null;
    }

    @Override
    public Category addSubCategory( UUID categoryParentId, UUID subCategoryId)
   {
        var  categoryEntity = categoryJPARepository.findById(subCategoryId);

        if(categoryEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }

        var categoryEntityParent = categoryJPARepository.findById(categoryParentId);
        if(categoryEntityParent.isEmpty()) {
            throw new EntityNotFoundException();
        }

        categoryEntity.get().setCategoryEntityParent(categoryEntityParent.get());


       Category category = categoryMapper.apply(categoryEntity.get());

       return update(category);
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
