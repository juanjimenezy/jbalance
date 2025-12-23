package com.jjimenez.jbalance.domain.model;

public class Salario {
    private Long id;
    private String concepto;
    private Double valor;
    private String estado;
    private String periodo;
    private Double SalarioExtra;
    private Double Prima;

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
        return SalarioExtra;
    }

    public void setSalarioExtra(Double salarioExtra) {
        SalarioExtra = salarioExtra;
    }

    public Double getPrima() {
        return Prima;
    }

    public void setPrima(Double prima) {
        Prima = prima;
    }
}
