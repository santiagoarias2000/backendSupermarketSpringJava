package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detallepedido")
public class detallePedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detallepedido")
    private Long idDetallePedido;

    @Column(name = "direccion")
    private String Direccion;

    @Column(name = "total_pedido")
    private Integer totalPedido;

    @JoinColumn(name="id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido idPedido;

    public detallePedido(Long idDetallePedido, String direccion, Integer totalPedido, Pedido idPedido) {
        this.idDetallePedido = idDetallePedido;
        Direccion = direccion;
        this.totalPedido = totalPedido;
        this.idPedido = idPedido;
    }

    public detallePedido() {

    }

    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Integer getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Integer totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }
}
