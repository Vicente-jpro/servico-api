package com.prestacao.servicoapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CidadeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome_cidade")
    private String nomeCidade;

    @JsonProperty("provincia")
    private ProvinciaDto provincia;
    // private List<EnderecoDto> enderecos;
}
