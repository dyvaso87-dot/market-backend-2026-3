package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
        @Mappings({
            @Mapping(soruce = "idCategoria",
                    target = "categoryId"),
            @Mapping(soruce = "descripcion",
                    target = "category"),
            @Mapping(soruce = "estado",
                    target = "active")
        })

        Category toCategory(Categoria categoria);

        @InheritConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
