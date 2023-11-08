package com.prestacao.servicoapi.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.models.Endereco;
import com.prestacao.servicoapi.services.EnderecoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    @ApiOperation("Salvar Endereço.")
    @ApiResponse(code = 200, message = "Endereço criado com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoDto> salvar(@RequestBody EnderecoDto enderecoDto) {
        log.info("Salvando o endereco...");

        Endereco endereco = enderecoService.salvar(enderecoDto);
        BeanUtils.copyProperties(endereco, enderecoDto);

        return ResponseEntity.ok(enderecoDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar endereço pelo ID.")
    @ApiResponse(code = 200, message = "Busca realizada com sucesso.")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable("id") Long idEndereco) {
        log.info("Buscando o endereço pelo ID: {}", idEndereco);

        Endereco endereco = enderecoService.getEnderecoById(idEndereco);
        EnderecoDto enderecoDto = new EnderecoDto();
        BeanUtils.copyProperties(endereco, enderecoDto);

        return ResponseEntity.ok(enderecoDto);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Atualizar endereço pelo ID.")
    @ApiResponse(code = 200, message = "Atualizar endereco pelo ID: ")
    public ResponseEntity<EnderecoDto> atualizar(@RequestBody EnderecoDto enderecoDto,
            @PathVariable("id") Long idEnderenco) {

        Endereco endereco = enderecoService.atualizar(enderecoDto, idEnderenco);
        BeanUtils.copyProperties(endereco, enderecoDto);

        return ResponseEntity.ok(enderecoDto);

    }

}
