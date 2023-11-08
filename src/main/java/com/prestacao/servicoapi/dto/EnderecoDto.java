package com.prestacao.servicoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private Long id;
    private String descricao;
    private CidadeDto cidade;

}
