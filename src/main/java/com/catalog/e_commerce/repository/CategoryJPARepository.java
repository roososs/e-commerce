package com.catalog.e_commerce.repository;
import com.catalog.e_commerce.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryJPARepository extends JpaRepository<CategoryEntity, UUID> {
}
