package com.senac.doador.dto;

import java.time.LocalDate;

public class DoacaoDTO {
    private Integer id;
    private LocalDate data;
    private Integer valor;
    private Integer status;
    private Integer doadorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Integer doadorId) {
        this.doadorId = doadorId;
    }
}
