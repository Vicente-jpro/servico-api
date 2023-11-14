package com.prestacao.servicoapi.bulders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.EnderecoDto;
import com.prestacao.servicoapi.models.Endereco;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoBuilder {
    private final CidadeBuilder cidadeBulder;

    public Endereco toModel(EnderecoDto enderecoDto) {
        return Endereco.builder()
                .id(enderecoDto.getId())
                .descricao(enderecoDto.getDescricao())
                .cidade(cidadeBulder.toModel(enderecoDto.getCidade()))
                .build();

    }

    public EnderecoDto toDto(Endereco endereco) {
        return EnderecoDto.builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBulder.toDto(endereco.getCidade()))
                .build();

    }
}
