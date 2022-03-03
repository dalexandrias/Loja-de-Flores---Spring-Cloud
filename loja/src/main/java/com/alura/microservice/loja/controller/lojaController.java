package com.alura.microservice.loja.controller;

import com.alura.microservice.loja.controller.dto.CompraDTO;
import com.alura.microservice.loja.model.Compra;
import com.alura.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class lojaController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(method = RequestMethod.POST)
    public Compra realizaCompra(@RequestBody CompraDTO compraDTO) {
        return compraService.realizaCompra(compraDTO);
    }

}
