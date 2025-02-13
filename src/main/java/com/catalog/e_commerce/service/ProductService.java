package com.catalog.e_commerce.service;

import com.catalog.e_commerce.dao.ProductJpaDao;
import com.catalog.e_commerce.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductJpaDao productJpaDao;


    public UUID addProduct(String name, String description, long price, int stock, UUID categoryId){
        return productJpaDao.save(name,description, price, stock, categoryId);
    }

    public Product updateProduct(Product product){
        return productJpaDao.update(product);
    }

    public Product deleteProduct(UUID productId){
        return productJpaDao.delete(productId);
    }
}
