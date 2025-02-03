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
@Table(name="catalog")
public class Catalog {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
    private Set<Category> categories;


}
