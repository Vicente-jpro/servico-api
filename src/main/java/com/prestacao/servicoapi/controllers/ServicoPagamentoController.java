package com.prestacao.servicoapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.services.ServicoPagamentoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/servico-pagamentos")
@RequiredArgsConstructor
public class ServicoPagamentoController {

    private final ServicoPagamentoService servicoPagamentoService;

    @PostMapping
    @ApiOperation("Salvar Servico Pagamento")
    @ApiResponse(code = 201, message = "Servico Pagamento Salvo com sucesso")
    public void salvar(@RequestBody ServicoPagamentoDto servicoPagamentoDto)
            throws JsonProcessingException {
        servicoPagamentoService.salvar(servicoPagamentoDto);
    }

}
