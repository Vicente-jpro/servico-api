package com.prestacao.servicoapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDto {

    private Long id;
    private String descricao;
    private CidadeDto cidade;

}
