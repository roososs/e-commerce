package com.catalog.e_commerce.service;

import com.catalog.e_commerce.dao.CatalogJpaDao;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.repository.CatalogJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CatalogService {

    private final CatalogJpaDao catalogJpaDao;

    public UUID addCatalog(String name){
        return catalogJpaDao.save(name);
    }
}
