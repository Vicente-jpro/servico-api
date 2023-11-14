package com.prestacao.servicoapi.dto;

import java.util.List;

import com.prestacao.servicoapi.models.Cliente;
import com.prestacao.servicoapi.models.UsuarioPerfil;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {

    private Integer id;
    private String username;
    private String email;
    private String passwrd;
    private List<UsuarioPerfil> usuarioPerfils;
    private List<Cliente> clientes;
}
