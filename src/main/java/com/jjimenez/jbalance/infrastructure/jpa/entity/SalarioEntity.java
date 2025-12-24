package com.jjimenez.jbalance.infrastructure.jpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "salario")
public class SalarioEntity {

    @Id
    private Long id;

    @Column("concepto")
    private String concepto;

    @Column("valor")
    private Double valor;

    @Column("estado")
    private String estado;

    @Column("periodo")
    private String periodo;

    @Column("salario_extra")
    private Double salarioExtra;

    @Column("prima")
    private Double prima;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Double getSalarioExtra() {
        return salarioExtra;
    }

    public void setSalarioExtra(Double salarioExtra) {
        this.salarioExtra = salarioExtra;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }
}
