package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "total_factura")
    private Integer totalFactura;

    @Column(name = "fecha")
    private Date Fecha;

    @JoinColumn(name="id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto idProducto;

    public Factura(Long idFactura, Integer totalFactura, Date fecha, Producto idProducto) {
        this.idFactura = idFactura;
        this.totalFactura = totalFactura;
        Fecha = fecha;
        this.idProducto = idProducto;
    }

    public Factura() {

    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Integer totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
}
