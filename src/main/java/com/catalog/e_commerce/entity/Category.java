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
public class Category {
    UUID id;
    String name;
    String description;

    @ManyToOne
    @JoinColumn(name="catalog_id", referencedColumnName ="id")
    private Catalog catalog;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private Category categoryParent;

    @OneToMany
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private Set<Category> subCategories;

    @OneToMany
    @JoinColumn(name="category_id", referencedColumnName ="id")
    private Set<Product> products;


}
