package com.alura.microservice.loja.controller.dto;

public class InfoFornecedorDTO {

    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

	@Override
	public String toString() {
		return "InfoFornecedorDTO [endereco=" + endereco + "]";
	}
    
    
}
