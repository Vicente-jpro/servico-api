package com.example.loja2023.Builders;

import org.springframework.stereotype.Component;

import com.example.loja2023.dto.ProvinciaDto;
import com.example.loja2023.models.Provincia;

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
