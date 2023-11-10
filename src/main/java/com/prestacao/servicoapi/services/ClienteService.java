package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.dto.ClienteDto;
import com.prestacao.servicoapi.models.Cliente;
import com.prestacao.servicoapi.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(ClienteDto clienteDto) {

    }
}
