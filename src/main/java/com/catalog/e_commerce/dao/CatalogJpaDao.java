package com.catalog.e_commerce.dao;

import com.catalog.e_commerce.entity.CatalogEntity;
import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.mapper.CatalogMapper;
import com.catalog.e_commerce.mapper.CategoryEntityMapper;
import com.catalog.e_commerce.mapper.CategoryMapper;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.repository.CatalogJPARepository;
import com.catalog.e_commerce.repository.CategoryJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CatalogJpaDao implements CatalogDao {

    private final CatalogJPARepository catalogJPARepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final CatalogMapper catalogMapper;

    public UUID save(String name){
        return catalogJPARepository.save(new CatalogEntity(name,null)).getId();
    }

    public Catalog update(Catalog catalog){
        final var catalogEntity = catalogJPARepository.findById(catalog.id());
        if(catalogEntity.isEmpty()){
            throw new EntityNotFoundException();
        }

        CatalogEntity entityToUpdate = catalogEntity.get();
        entityToUpdate.setName(catalog.name());

         Set<CategoryEntity> categoriesEntities = catalog.categories().stream().map(categoryEntityMapper).collect(Collectors.toSet());
         entityToUpdate.setCategories(categoriesEntities);

        catalogJPARepository.save(entityToUpdate);

         return catalogMapper.apply(entityToUpdate);
    }

    public Catalog delete(UUID catalogId){
        return null;
    }

    public UUID linkCategory(UUID categoryId){
        return null;
    }

    public Category unlinkCategory(UUID categoryId){
        return null;
    }
}
