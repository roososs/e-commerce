package com.catalog.e_commerce.service;

import com.catalog.e_commerce.dao.CategoryJpaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

public class CategoryServiceTest {
    @Mock
    private CategoryJpaDao categoryJpaDao;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
}
