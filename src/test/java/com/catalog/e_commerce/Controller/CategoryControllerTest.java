package com.catalog.e_commerce.Controller;

import com.catalog.e_commerce.controller.CategoryController;
import com.catalog.e_commerce.dto.CategoryAddDto;
import com.catalog.e_commerce.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCategory() {
        CategoryAddDto categoryAddDto = new CategoryAddDto("Electronics", "Electronic items", UUID.randomUUID(), null);
        UUID categoryId = UUID.randomUUID();

        when(categoryService.addCategory(categoryAddDto.name(), categoryAddDto.description(), categoryAddDto.catalogId(), categoryAddDto.categoryParentId()))
                .thenReturn(categoryId);

        ResponseEntity<UUID> response = categoryController.addCategory(categoryAddDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(categoryId, response.getBody());
    }
}