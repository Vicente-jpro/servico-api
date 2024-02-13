package com.prestacao.servicoapi.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prestacao.servicoapi.enums.GeneroEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {

    private Long id;
    private String nome;
    private String telemovel1;
    private String telemovel2;
    private GeneroEnum genero;
    private EnderecoDto endereco;
    private UsuarioResponseDto usuario;
    private LocalDateTime dataCadastro;
}
