package com.jjimenez.jbalance.infrastructure.jpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("movimientos")
public class MovimientoEntity {
    @Id
    private Long id;

    @Column("id_gasto_fijo")
    private Long idGastoFijo;

    @Column("descripcion")
    private String descripcion;

    @Column("valor")
    private Double valor;

    @Column("fecha")
    private LocalDate fecha;

    @Column("periodo")
    private String periodo;

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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
