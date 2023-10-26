package com.example.loja2023.services;

import org.springframework.stereotype.Service;

import com.example.loja2023.exceptions.ProvinciaNotFoundException;
import com.example.loja2023.models.Provincia;
import com.example.loja2023.repositories.ProvinciaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    public Provincia getProvinciaById(Long idProvincia) {
        log.info("Buscar a provinca com ID: {}", idProvincia);
        return provinciaRepository.findById(idProvincia)
                .orElseThrow(() -> new ProvinciaNotFoundException("Provincia não encontrada"));
    }

}
