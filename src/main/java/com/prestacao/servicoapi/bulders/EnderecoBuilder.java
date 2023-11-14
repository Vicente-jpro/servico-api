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
        return new Endereco(
                enderecoDto.getId(),
                enderecoDto.getDescricao(),
                cidadeBulder.toModel(enderecoDto.getCidade()),
                null,
                null);

    }

    public EnderecoDto toDto(Endereco endereco) {
        return EnderecoDto.builder()
                .id(endereco.getId())
                .descricao(endereco.getDescricao())
                .cidade(cidadeBulder.toDto(endereco.getCidade()))
                .build();

    }
}
