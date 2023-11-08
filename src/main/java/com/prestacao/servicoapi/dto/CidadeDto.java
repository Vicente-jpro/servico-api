package com.prestacao.servicoapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CidadeDto {

    private Long id;
    private String nomeCidade;
    private ProvinciaDto provincia;
    // private List<EnderecoDto> enderecos;
}
