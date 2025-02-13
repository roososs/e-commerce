package com.catalog.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue
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
        this.subCategories = Collections.emptySet();
        this.productEntities = Collections.emptySet();
    }

}
