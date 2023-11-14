package com.prestacao.servicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ApiOperation(value = "Salvar cliente.")
    @ApiResponse(code = 200, message = "Cliente salvo com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto salvar(@RequestBody ClienteDto clienteDto) {
        log.info("Salvar cliente.");
        return clienteService.salvar(clienteDto);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar cliente pelo id.")
    @ApiResponse(code = 200, message = "Cliente encontrado.")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDto getClienteById(@PathVariable("id") Long idCliente) {
        log.info("Buscar cliente.");
        return clienteService.getClienteById(idCliente);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar cliente pelo id.")
    @ApiResponse(code = 200, message = "Cliente eliminado com sucesso.")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id") Long idCliente) {
        log.info("Eliminar cliente.");
        clienteService.eliminar(idCliente);
    }
}
