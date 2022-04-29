package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "numero_pedido")
    private String numeroPedido;

    @Column(name = "descripcion")
    private String Descripcion;

    @JoinColumn(name="id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto idProducto;

    public Pedido(Long idPedido, String numeroPedido, String descripcion, Producto idProducto) {
        this.idPedido = idPedido;
        this.numeroPedido = numeroPedido;
        Descripcion = descripcion;
        this.idProducto = idProducto;
    }

    public Pedido() {

    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
}
