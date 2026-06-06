package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.mapper;

import mx.edu.tecdesoftware.market_backend_2026_3_a.domain.service.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(soruce = "idProducto",
                    target = "productoId"),
            @Mapping(soruce = "nombre",
                    target = "name"),
            @Mapping(soruce = "precioVenta",
                    target = "price"),
            @Mapping(soruce = "cantidadStock",
                    target = "stock"),
            @Mapping(soruce = "estado",
                    target = "active"),
            @Mapping(soruce = "categoria",
                    target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
