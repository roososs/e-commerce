package com.catalog.e_commerce.model;

import java.util.Set;
import java.util.UUID;

public record Catalog(UUID id, String name, Set<UUID> categoryIds) {
}
