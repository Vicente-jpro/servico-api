package com.example.loja2023.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja2023.Builders.CidadeBuilder;
import com.example.loja2023.dto.CidadeDto;
import com.example.loja2023.dto.EnderecoDto;
import com.example.loja2023.models.Endereco;
import com.example.loja2023.services.EnderecoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final CidadeBuilder cidadeBuilder;

    @PostMapping
    public ResponseEntity<EnderecoDto> salvar(@RequestBody EnderecoDto enderecoDto) {
        Endereco endereco = enderecoService.salvar(enderecoDto);

        enderecoDto = EnderecoDto
                .builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBuilder.toCidadeDto(endereco.getCidade()))
                .build();
        return ResponseEntity.ok(enderecoDto);
    }

}
