package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ProvinciaDto;
import com.prestacao.servicoapi.models.Provincia;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProvinciaBulder {

    public ProvinciaDto toProvinciaDto(Provincia provincia) {
        return ProvinciaDto
                .builder()
                .id(provincia.getId())
                .nomeProvincia(provincia.getNomeProvincia())
                .build();
    }

    public ProvinciaDto toProvinciaDto(ProvinciaDto provinciaDto) {
        return ProvinciaDto
                .builder()
                .id(provinciaDto.getId())
                .nomeProvincia(provinciaDto.getNomeProvincia())
                .build();
    }
}
