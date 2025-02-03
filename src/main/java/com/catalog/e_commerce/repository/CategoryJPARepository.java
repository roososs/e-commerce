package com.catalog.e_commerce.repository;

import com.catalog.e_commerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryJPARepository extends JpaRepository<Category, UUID> {
}
