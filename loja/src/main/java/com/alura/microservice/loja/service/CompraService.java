package com.alura.microservice.loja.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.microservice.loja.controller.dto.CompraDTO;
import com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.alura.microservice.loja.controller.dto.InfoPedidoDTO;
import com.alura.microservice.loja.controller.dto.ItensDaCompraDTO;
import com.alura.microservice.loja.model.Compra;
import com.alura.microservice.loja.service.client.FornecedorClient;

@Service
public class CompraService {
	
	@Autowired
	FornecedorClient fornecedorClient;
	
    public Compra realizaCompra(CompraDTO compraDTO) {
    	
    	final Logger LOG = LoggerFactory.getLogger(CompraService.class);
    	
    	final String estado = compraDTO.getEndereco().getEstado();
    	final List<ItensDaCompraDTO> itensPedido = compraDTO.getItens();
    	
    	LOG.info("Buscando informações do fornecedor {}", estado);
        InfoFornecedorDTO infoEstado = fornecedorClient.getInfoPorEstado(estado);
        
        LOG.info("Realizando pedido dos itens: {}", itensPedido);
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(itensPedido);
        
        Compra compra = new Compra();
        
        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(infoEstado.getEndereco().toString());
        
        LOG.info("Compra realizada com sucesso: {}", compra.toString());
        
        return compra;
    }
}
