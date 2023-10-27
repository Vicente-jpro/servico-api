package com.example.loja2023.Builders;

import org.springframework.stereotype.Component;

import com.example.loja2023.dto.CidadeDto;
import com.example.loja2023.dto.EnderecoDto;
import com.example.loja2023.models.Endereco;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoBuilder {

    private final CidadeBuilder cidadeBuilder;

    public EnderecoDto toEnderecoDto(Endereco endereco) {
        return EnderecoDto
                .builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBuilder.toCidadeDto(endereco.getCidade()))
                .build();
    }
}
