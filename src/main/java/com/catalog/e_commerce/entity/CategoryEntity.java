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


}
