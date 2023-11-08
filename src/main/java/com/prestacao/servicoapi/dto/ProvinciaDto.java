package com.prestacao.servicoapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinciaDto {

    private Long id;
    private String nomeProvincia;
    // private List<CidadeDto> cidades;
}
