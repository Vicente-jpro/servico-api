package com.prestacao.servicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.services.ServicoPrestadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/servico-prestado")
public class ServicoPrestadoController {

    private final ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    @ApiOperation("Salvar Servico Prestados")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Servico Prestado salvo com sucesso.")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestadoDto salvar(@RequestBody ServicoPrestadoDto servicoPrestadoDto) {
        log.info("Salvar Servico Prestado.");
        return servicoPrestadoService.salvar(servicoPrestadoDto);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Atualizar Servico Prestados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Servico Prestado atualizado com sucesso.")
    })
    @ResponseStatus(HttpStatus.OK)
    public ServicoPrestadoDto atualizar(
            @RequestBody ServicoPrestadoDto servicoPrestadoDto,
            @PathVariable("id") Long idServicoPrestado) {
        log.info("Atualizar servico prestado.");
        return servicoPrestadoService.atualizar(servicoPrestadoDto, idServicoPrestado);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar Servico Prestados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Servico Prestado buscado com sucesso.")
    })
    @ResponseStatus(HttpStatus.OK)
    public ServicoPrestadoDto getServicoPrestado(@PathVariable("id") Long idServicoPrestado) {
        log.info("Buscar servico prestado.");
        return servicoPrestadoService.getServicoPrestadoById(idServicoPrestado);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar Servico Prestados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Servico Prestado eliminado com sucesso.")
    })
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id") Long idServicoPrestado) {
        log.info("Eliminar servico prestado.");
        servicoPrestadoService.eliminar(idServicoPrestado);
    }

}
