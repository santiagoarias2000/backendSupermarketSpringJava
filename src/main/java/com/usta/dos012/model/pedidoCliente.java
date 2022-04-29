package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidocliente")
public class pedidoCliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidocliente")
    private Long idPedidoCliente;

    @Column(name = "descripcion")
    private String Descripcion;

    @JoinColumn(name="id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido idPedido;

    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente idCliente;

    public pedidoCliente(Long idPedidoCliente, String descripcion, Pedido idPedido, Cliente idCliente) {
        this.idPedidoCliente = idPedidoCliente;
        Descripcion = descripcion;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
    }

    public pedidoCliente() {

    }

    public Long getIdPedidoCliente() {
        return idPedidoCliente;
    }

    public void setIdPedidoCliente(Long idPedidoCliente) {
        this.idPedidoCliente = idPedidoCliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
}
