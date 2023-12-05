package com.prestacao.servicoapi.services;

import org.springframework.stereotype.Service;

import com.prestacao.servicoapi.repositories.ServicoPrestadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {

    private final ServicoPrestadoRepository servicoPrestadoRepository;
}
