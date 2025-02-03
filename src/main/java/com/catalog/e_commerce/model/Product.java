package com.catalog.e_commerce.model;

import java.util.UUID;

public record Product(UUID id, String name, String description, long price, int stock, UUID categoryId) {
}
