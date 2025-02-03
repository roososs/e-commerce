package com.catalog.e_commerce.mapper;
import com.catalog.e_commerce.entity.ProductEntity;
import com.catalog.e_commerce.model.Product;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class ProductMapper implements Function<ProductEntity, Product> {

    @Override
    public Product apply(ProductEntity productEntity) {
        return new Product(productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock(),
                productEntity.getCategoryEntity().getId());
    }
}
