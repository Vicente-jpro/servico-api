package com.prestacao.servicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ApiOperation(value = "Salvar cliente.")
    @ApiResponse(code = 200, message = "Cliente salvo com sucesso")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto salvar(@RequestBody ClienteDto clienteDto) {
        return clienteService.salvar(clienteDto);
    }

}
