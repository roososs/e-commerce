package com.catalog.e_commerce.repository;

import com.catalog.e_commerce.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatalogueJPARepository extends JpaRepository<Catalog, UUID> {
}
