package com.example.loja2023.builders;

import org.springframework.stereotype.Component;

import com.example.loja2023.dto.CidadeDto;
import com.example.loja2023.models.Cidade;

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
