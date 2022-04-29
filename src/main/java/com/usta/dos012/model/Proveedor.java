package com.usta.dos012.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "nit_proveedor")
    private String nitProveedor;

    @Column(name = "direccion")
    private String Direccion;

    public Proveedor(Long idProveedor, String nombreProveedor, String nitProveedor, String direccion) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.nitProveedor = nitProveedor;
        Direccion = direccion;
    }

    public Proveedor() {

    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
