package com.catalog.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    private long price;

    private int stock;

    @ManyToOne
    @JoinColumn(name= "category_id", referencedColumnName = "id")
    private Category category;

}
