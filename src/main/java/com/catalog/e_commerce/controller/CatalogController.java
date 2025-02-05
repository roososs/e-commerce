package com.catalog.e_commerce.controller;

import com.catalog.e_commerce.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/catalogs")
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping("/")
    public ResponseEntity<UUID> addCatalog(@RequestBody String name){
       UUID catalogId = catalogService.addCatalog(name);
       return new ResponseEntity<>(catalogId, HttpStatus.CREATED);
    }
}

