package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.crud;

import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository
        extends CrudRepository<Producto, Integer> {
    //Query Method
    /*
    SELECT *
    FROM categorias
    WHERE id_categoria = ?
    ORDER BY nombre ASC
     */

    //Obtener una Lista de productos filtrados por id de categoria
    // y ordenados ascendentemente por nombre

    List<Producto>findByCategoriaOrderByNombreAsc(int idCategoria);

    //Obtener los productos con bajo stock
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(
            int cantidad, boolean estado);
}
