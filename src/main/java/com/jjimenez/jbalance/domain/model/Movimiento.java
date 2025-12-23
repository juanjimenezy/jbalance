package com.jjimenez.jbalance.domain.model;

import java.time.LocalDate;

public class Movimiento {
    private Long id;
    private Long idGastoFijo;
    private String descripcion;
    private Double valor;
    private LocalDate fecha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdGastoFijo() {
        return idGastoFijo;
    }

    public void setIdGastoFijo(Long idGastoFijo) {
        this.idGastoFijo = idGastoFijo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
