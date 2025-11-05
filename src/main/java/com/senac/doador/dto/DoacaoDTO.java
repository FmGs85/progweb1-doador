package com.senac.doador.dto;

public class DoacaoDTO {
    private Integer id;
    private Integer doadorId;
    private String descricao;
    private Double valor;
    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Integer doadorId) {
        this.doadorId = doadorId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}