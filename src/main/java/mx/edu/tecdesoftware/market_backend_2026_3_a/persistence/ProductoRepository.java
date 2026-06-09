package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_a.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_a.domain.service.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
// Le dices a Spring que esta clase
// se comunca con la BD
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    //SELECT * FROM productos
    public List<Product> getAll(){
        //Se "castea" de Iterable a la Lista
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    public Optional<List<Product>> getScareProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(
                quantity, true);
        return Optional.of(productMapper.toProducts(productos.get()));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    //Obtener un prodcuto dado el ID
    public Optional<Product> getProducto(int productId) {

        return productoCrudRepository.findById(productId)
                .map(producto -> productMapper.toProduct(producto));
    }

    //Guardar un producto
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    //Eliminar por id
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}