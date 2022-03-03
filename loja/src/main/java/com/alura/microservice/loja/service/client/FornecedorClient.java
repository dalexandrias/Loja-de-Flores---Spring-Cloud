package com.alura.microservice.loja.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.alura.microservice.loja.controller.dto.InfoPedidoDTO;
import com.alura.microservice.loja.controller.dto.ItensDaCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItensDaCompraDTO> itens);
}
