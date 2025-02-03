package com.catalog.e_commerce.model;

import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.entity.ProductEntity;

import java.util.Set;
import java.util.UUID;

public record Category(UUID id, String name, String description, UUID catalogueId, UUID categoryParentId, Set<Category> subCategories, Set<Product> products) {
}
