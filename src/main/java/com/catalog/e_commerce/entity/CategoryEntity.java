package com.catalog.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class CategoryEntity {
    UUID id;
    String name;
    String description;

    @ManyToOne
    @JoinColumn(name="catalog_id", referencedColumnName ="id")
    private CatalogEntity catalogEntity;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private CategoryEntity categoryEntityParent;

    @OneToMany
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private Set<CategoryEntity> subCategories;

    @OneToMany
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private Set<ProductEntity> productEntities;


    public CategoryEntity(String name, String description, CatalogEntity catalogEntity, CategoryEntity categoryEntityParent) {
        this.name = name;
        this.description = description;
        this.catalogEntity = catalogEntity;
        this.categoryEntityParent = categoryEntityParent;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CatalogEntity getCatalogEntity() {
        return catalogEntity;
    }

    public CategoryEntity getCategoryEntityParent() {
        return categoryEntityParent;
    }

    public Set<CategoryEntity> getSubCategories() {
        return subCategories;
    }

    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }
}
