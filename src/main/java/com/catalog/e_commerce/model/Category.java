package com.catalog.e_commerce.model;

import java.util.Set;
import java.util.UUID;

public record Category(UUID id, String name, String description, UUID catalogueId, UUID categoryParentId, Set<UUID> subCategoryIds, Set<UUID> productIds) {
}
