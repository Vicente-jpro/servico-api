package com.example.loja2023.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja2023.Builders.CidadeBuilder;

import com.example.loja2023.dto.EnderecoDto;
import com.example.loja2023.models.Endereco;
import com.example.loja2023.services.EnderecoService;

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
    private final CidadeBuilder cidadeBuilder;

    @PostMapping
    @ApiOperation("Salvar Endereço.")
    @ApiResponse(code = 200, message = "Endereço criado com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoDto> salvar(@RequestBody EnderecoDto enderecoDto) {
        log.info("Salvando o endereco...");
        Endereco endereco = enderecoService.salvar(enderecoDto);

        enderecoDto = EnderecoDto
                .builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBuilder.toCidadeDto(endereco.getCidade()))
                .build();
        return ResponseEntity.ok(enderecoDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar endereço pelo ID.")
    @ApiResponse(code = 200, message = "Busca realizada com sucesso.")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable("id") Long idEndereco) {
        log.info("Buscando o endereço pelo ID: {}", idEndereco);
        Endereco endereco = enderecoService.getEnderecoById(idEndereco);

        EnderecoDto enderecoDto = EnderecoDto
                .builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBuilder.toCidadeDto(endereco.getCidade()))
                .build();
        return ResponseEntity.ok(enderecoDto);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Atualizar endereço pelo ID.")
    @ApiResponse(code = 200, message = "Atualizar endereco pelo ID: ")
    public ResponseEntity<EnderecoDto> atualizar(@RequestBody EnderecoDto enderecoDto,
            @PathVariable("id") Long idEnderenco) {

        Endereco endereco = enderecoService.atualizar(enderecoDto, idEnderenco);

        enderecoDto = EnderecoDto
                .builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBuilder.toCidadeDto(endereco.getCidade()))
                .build();
        return ResponseEntity.ok(enderecoDto);

    }

}
