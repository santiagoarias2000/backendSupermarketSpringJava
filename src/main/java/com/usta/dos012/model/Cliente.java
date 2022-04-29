package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombres")
    private String Nombres;

    @Column(name = "apellido")
    private String Apellido;

    @Column(name = "identificacion")
    private String Identificacion;

    @Column(name = "telefono")
    private Integer Telefono;

    public Cliente(Long idCliente, String nombres, String apellido, String identificacion, Integer telefono) {
        this.idCliente = idCliente;
        Nombres = nombres;
        Apellido = apellido;
        Identificacion = identificacion;
        Telefono = telefono;
    }

    public Cliente() {

    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }
}
