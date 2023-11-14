package com.prestacao.servicoapi.bulders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ProvinciaDto;
import com.prestacao.servicoapi.models.Provincia;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProvinciaBuilder {

    public Provincia toModel(ProvinciaDto provinciaDto) {
        return new Provincia(
                provinciaDto.getId(), provinciaDto.getNomeProvincia(), null);
    }

    public ProvinciaDto toDto(Provincia provincia) {
        return ProvinciaDto
                .builder()
                .id(provincia.getId())
                .nomeProvincia(provincia.getNomeProvincia())
                .build();
    }

}
