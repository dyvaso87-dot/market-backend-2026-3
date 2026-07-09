package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_a.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3_a.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity.Compra_Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;
    private final PurchaseMapper purchaseMapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper purchaseMapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return purchaseMapper.toPurchases(compras);
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        List<Compra> compras = compraCrudRepository.findByIdCliente(clientId);
        return Optional.of(purchaseMapper.toPurchases(compras));
    }

    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);

        if (compra.getIdCompra() != null && compra.getIdCompra() == 0) {
            compra.setIdCompra(null);
        }

        if (compra.getProductos() != null) {
            compra.getProductos().forEach(producto -> preparePurchaseItem(compra, producto));
        }

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }

    private void preparePurchaseItem(Compra compra, Compra_Producto producto) {
        producto.setCompra(compra);
        if (producto.getId() != null && producto.getId().getIdCompra() != null && producto.getId().getIdCompra() == 0) {
            producto.getId().setIdCompra(null);
        }
    }
}