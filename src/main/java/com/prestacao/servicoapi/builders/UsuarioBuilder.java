package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.UsuarioDto;
import com.prestacao.servicoapi.dto.UsuarioResponseDto;
import com.prestacao.servicoapi.models.Usuario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioBuilder {

    public Usuario toModel(UsuarioDto usuarioDto) {
        return Usuario
                .builder()
                .idUsuario(usuarioDto.getId())
                .username(usuarioDto.getUsername())
                .email(usuarioDto.getEmail())
                .passwrd(usuarioDto.getPasswrd())
                .build();
    }

    public Usuario toModel(UsuarioResponseDto usuarioDto) {
        return Usuario
                .builder()
                .idUsuario(usuarioDto.getId())
                .username(usuarioDto.getUsername())
                .email(usuarioDto.getEmail())
                .build();
    }

    public UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto
                .builder()
                .id(usuario.getIdUsuario())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .passwrd(usuario.getPasswrd())
                .build();
    }

    public UsuarioResponseDto toResponseDto(Usuario usuario) {
        return UsuarioResponseDto
                .builder()
                .id(usuario.getIdUsuario())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .build();
    }

}
