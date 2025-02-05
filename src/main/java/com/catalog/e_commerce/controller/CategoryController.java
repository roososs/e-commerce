package com.catalog.e_commerce.controller;

import com.catalog.e_commerce.dto.CategoryDto;
import com.catalog.e_commerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<UUID> addCategory(@RequestBody CategoryDto categoryDto){
        UUID categoryId = categoryService.addCategory( categoryDto.name(), categoryDto.description(),  categoryDto.catalogId(), categoryDto.categoryParentId());
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }
}
