package com.catalog.e_commerce.dto;

import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;

import java.util.Set;
import java.util.UUID;

public record CategoryUpdateDto(UUID id, String name, String description, UUID catalogId, UUID categoryParentId)  {
}
