package com.senac.doador.dto;

import jakarta.persistence.Column;

import java.util.List;

public class DoadorDTO {
    private Integer id;
    private String nome;
    private String endereco;
    private Integer status;
    List<DoacaoDTO> doacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DoacaoDTO> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<DoacaoDTO> doacoes) {
        this.doacoes = doacoes;
    }
}
