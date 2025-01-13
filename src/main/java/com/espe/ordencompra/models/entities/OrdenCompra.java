package com.espe.ordencompra.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name="OrdenesCompra")


public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El proveedor no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre del proveedor debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false)
    private String provedoor;

    @NotEmpty(message = "La descripción no puede estar vacía.")
    @Size(min = 10, max = 255, message = "La descripción debe tener entre 10 y 255 caracteres.")
    @Column(nullable = false)
    private String descripcion;


    @Min(value = 1, message = "La cantidad debe ser mayor o igual a 1.")
    @Column(nullable = false)
    private int cantidad;


    @NotNull(message = "La fecha de orden no puede ser nula.")
    @PastOrPresent(message = "La fecha de orden no puede ser una fecha futura.")
    @Column(nullable = false)
    private Date fechaOrden;


    //getters y setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvedoor() {
        return provedoor;
    }

    public void setProvedoor(String provedoor) {
        this.provedoor = provedoor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
}
