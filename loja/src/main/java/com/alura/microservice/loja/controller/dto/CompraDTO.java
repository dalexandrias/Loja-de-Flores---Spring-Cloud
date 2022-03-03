package com.alura.microservice.loja.controller.dto;

import java.util.List;

public class CompraDTO {

    private List<ItensDaCompraDTO> itens;
    private EnderecoDTO endereco;

    public List<ItensDaCompraDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensDaCompraDTO> itens) {
        this.itens = itens;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
