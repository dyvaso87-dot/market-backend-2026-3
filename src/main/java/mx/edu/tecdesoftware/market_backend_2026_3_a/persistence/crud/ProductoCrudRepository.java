package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.crud;

import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //query method
    /*
    SELECT *
    FROM categorias
    WHERE id_categoria =
    ORDER BY nombre ASC
     */
    //Obtener una lista de productos filtrados por id categoria
    // y ordenar ascendentemente por nombre
    List<Producto> findByIdcategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findCantidadStockLessThanAndEstado(int cantidad,boolean estado);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean b);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
}