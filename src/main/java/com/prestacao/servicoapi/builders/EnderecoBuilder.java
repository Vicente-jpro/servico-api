package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.models.Endereco;

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
