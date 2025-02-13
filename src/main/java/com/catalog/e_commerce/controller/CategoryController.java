package com.catalog.e_commerce.controller;

import com.catalog.e_commerce.dto.CategoryAddDto;
import com.catalog.e_commerce.dto.CategoryUpdateDto;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import com.catalog.e_commerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<UUID> addCategory(@Validated @RequestBody CategoryAddDto categoryAddDto){
        UUID categoryId = categoryService.addCategory( categoryAddDto.name(), categoryAddDto.description(),  categoryAddDto.catalogId(), categoryAddDto.categoryParentId());
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    @PatchMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID categoryId, @Validated @RequestBody CategoryUpdateDto categoryUpdateDto){
        Category category = categoryService.updateCategory(new Category(categoryId, categoryUpdateDto.name(), categoryUpdateDto.description(), categoryUpdateDto.catalogId(), categoryUpdateDto.categoryParentId(),Collections.emptySet(), Collections.emptySet()));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
