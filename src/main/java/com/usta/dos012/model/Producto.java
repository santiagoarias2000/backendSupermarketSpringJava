package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad_disponible")
    private Integer cantidadDisponible;

    @Column(name = "descripcion")
    private String Descripcion;

    @Column(name = "precio")
    private Integer Precio;

    @Column(name = "iva")
    private Double Iva;

    @JoinColumn(name="id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proveedor idProveedor;

    public Producto(Long idProducto, String nombreProducto, Integer cantidadDisponible, String descripcion, Integer precio, Double iva, Proveedor idProveedor) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadDisponible = cantidadDisponible;
        Descripcion = descripcion;
        Precio = precio;
        Iva = iva;
        this.idProveedor = idProveedor;
    }

    public Producto() {

    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer precio) {
        Precio = precio;
    }

    public Double getIva() {
        return Iva;
    }

    public void setIva(Double iva) {
        Iva = iva;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }
}
