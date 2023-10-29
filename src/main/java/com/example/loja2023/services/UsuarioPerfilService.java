package com.example.loja2023.services;

import org.springframework.stereotype.Service;

import com.example.loja2023.repositories.UsuarioPerfilRepositoy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioPerfilService {

    private final UsuarioPerfilRepositoy usuarioPerfilRepositoy;
    private final UsuarioService usuarioService;

}
