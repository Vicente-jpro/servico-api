package com.example.loja2023.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDto {

    private Long id;
    private String descricao;
    private CidadeDto cidade;
}
