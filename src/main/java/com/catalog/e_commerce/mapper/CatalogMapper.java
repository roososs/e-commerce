package com.catalog.e_commerce.mapper;
import com.catalog.e_commerce.entity.CatalogEntity;
import com.catalog.e_commerce.model.Catalog;
import com.catalog.e_commerce.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CatalogMapper implements Function<CatalogEntity, Catalog> {

    private final CategoryMapper categoryMapper;

    @Override
    public Catalog apply(CatalogEntity catalogEntity) {
        Set<Category> categoriesList = catalogEntity.getCategories().stream().map(categoryMapper).collect(Collectors.toSet());
        return new Catalog(catalogEntity.getId(), catalogEntity.getName(), categoriesList);
    }
}
