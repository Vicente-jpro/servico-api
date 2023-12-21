package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.CidadeDto;
import com.prestacao.servicoapi.models.Cidade;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CidadeBuilder {
    private final ProvinciaBuilder provinciaBuilder;

    public Cidade toModel(CidadeDto cidadeDto) {
        return Cidade
                .builder()
                .id(cidadeDto.getId())
                .nomeCidade(cidadeDto.getNomeCidade())
                .provincia(provinciaBuilder.toModel(cidadeDto.getProvincia()))
                .build();
    }

    public CidadeDto toDto(Cidade cidade) {
        return CidadeDto
                .builder()
                .id(cidade.getId())
                .nomeCidade(cidade.getNomeCidade())
                .provincia(provinciaBuilder.toDto(cidade.getProvincia()))
                .build();
    }
}
