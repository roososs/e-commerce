package com.catalog.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="catalog")
public class CatalogEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
    private Set<CategoryEntity> categories;

    public CatalogEntity(String name, Set<CategoryEntity> categoriesEntity){
        this.name=name;
        this.categories= categoriesEntity;
    }

}
