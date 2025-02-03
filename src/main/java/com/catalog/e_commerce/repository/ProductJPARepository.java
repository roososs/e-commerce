package com.catalog.e_commerce.repository;

import com.catalog.e_commerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJPARepository extends JpaRepository<ProductEntity, UUID> {
}
