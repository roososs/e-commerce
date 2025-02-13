package com.catalog.e_commerce.mapper;
import com.catalog.e_commerce.entity.CategoryEntity;
import com.catalog.e_commerce.model.Category;
import com.catalog.e_commerce.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CategoryMapper implements Function <CategoryEntity, Category>{

    private final ProductMapper productMapper;

    @Override
    public Category apply(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }

        Set<Product> products = categoryEntity.getProductEntities()
                .stream()
                .map(productMapper)
                .collect(Collectors.toSet()) ;

        final var subCategories = applyList(categoryEntity.getSubCategories());

        final var categoryParentId = categoryEntity.getCategoryEntityParent() != null ?
                categoryEntity.getCategoryEntityParent().getId()
                : null;

        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription(),
                categoryEntity.getCatalogEntity().getId(),
                categoryParentId,
                subCategories,
                products
        );
    }

    private Set<Category> applyList(Set<CategoryEntity> categoryEntityList){
        final var categoryList = categoryEntityList.stream()
                        .map(this)
                        .collect(Collectors.toSet());
        return categoryList;
    }

}
