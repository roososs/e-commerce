package com.catalog.e_commerce.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private long price;

    private int stock;

    @ManyToOne
    @JoinColumn(name= "category_id", referencedColumnName = "id")
    private CategoryEntity categoryEntity;

    public ProductEntity(String name, String description, long price, int stock, CategoryEntity categoryEntity) {
        this.name = name;
        this.description = description;
        this.categoryEntity = categoryEntity;
        this.price = price;
        this.stock = stock;
    }
}
