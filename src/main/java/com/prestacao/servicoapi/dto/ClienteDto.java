package com.prestacao.servicoapi.dto;

import java.time.LocalDateTime;

import com.prestacao.servicoapi.enums.Genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {

    private Long id;
    private String nome;
    private String telemovel1;
    private String telemovel2;
    private Genero genero;
    private EnderecoDto endereco;
    private UsuarioResponseDto usuario;
    private LocalDateTime dataCadastro;
}
