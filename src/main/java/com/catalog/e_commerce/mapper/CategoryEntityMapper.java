package com.catalog.e_commerce.mapper;

import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.model.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryEntityMapper implements Function<Category, CategoryEntity> {
    @Override
    public CategoryEntity apply(Category category) {
        return null;
    }
}
