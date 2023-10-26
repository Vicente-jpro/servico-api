package com.example.loja2023.services;

import org.springframework.stereotype.Service;

import com.example.loja2023.repositories.EnderecoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final CidadeService cidadeService;
    private final EnderecoRepository enderecoRepository;

}
