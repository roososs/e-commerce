package com.catalog.e_commerce.dto;

import java.util.UUID;

public record ProductAddDto(String name, String description, long price, int stock, UUID categoryId) {
}
