package mx.edu.tecdesoftware.market_backend_2026_3_a.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "prodcutos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id:Producto")
    private Integer idProducto;

    private String nombre;

    @Column (name = "id:categoria")
    private Integer id_categoria;

    @Column (name = "codigo_barras")
    private Integer codigoBarras;

    @Column (name = "precio_venta")
    private Integer precioVenta;

    @Column (name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;
}
