package com.catalog.e_commerce.dto;

import java.util.UUID;

public record CategoryDto(String name, String description, UUID catalogId, UUID categoryParentId) {
}

