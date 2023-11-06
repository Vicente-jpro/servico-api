package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.CidadeDto;
import com.prestacao.servicoapi.models.Cidade;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CidadeBuilder {

    private final ProvinciaBulder provinciaBulder;

    public CidadeDto toCidadeDto(Cidade cidade) {
        return CidadeDto
                .builder()
                .id(cidade.getId())
                .nomeCidade(cidade.getNomeCidade())
                .provincia(provinciaBulder.toProvinciaDto(cidade.getProvincia()))
                .build();
    }

    public CidadeDto toCidadeDto(CidadeDto cidadeDto) {
        return CidadeDto
                .builder()
                .id(cidadeDto.getId())
                .nomeCidade(cidadeDto.getNomeCidade())
                .provincia(provinciaBulder.toProvinciaDto(cidadeDto.getProvincia()))
                .build();
    }
}
