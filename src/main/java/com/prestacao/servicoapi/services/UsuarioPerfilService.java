package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.repositories.UsuarioPerfilRepositoy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioPerfilService {

    private final UsuarioPerfilRepositoy usuarioPerfilRepositoy;
    private final UsuarioService usuarioService;

}
